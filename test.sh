#! /bin/bash
#####################################################################################################################
# Job Name: split_by_version_ut.sh (THIS VERSION HAS A HARDCODED ENV OF U)
#
# Shell: bash (Bourne-Again SHell)
#
# Description:
# ------------
# This script will read all of the files in a folder (one file at a time, line by line) and write each line to a file
# corresponding to the version number field (for example vnbr 1 will be written to <original_filename>.V000000001).
#
# Result codes
# ------------
#   0 - job ran successfully
#   1 - job did not run successfully
#
# History
# -------
# Date			Userid			Description
# 2019-07-26	lxb125			Initial version
#####################################################################################################################

# this function defines the output file name with the version number appended as a suffix and writes the line without the version number to it
write_line ()
{
	# define a variable called output_name_ver by concatenating the output_name variable followed by a period and a capital v and then the version number
	export output_name_ver=${output_name}.V${version_nbr}
	# write the line without the version number field to the corresponding version number output file
	echo "$line_wo_ver" >> $output_name_ver
}


### mainline starts here

# this script is specifically for UT, we hardcode env=u
export env=u

# this for loop reads all of the files in the specified folder one file at a time (note: variable file contains the full path and the file name)
for file in /disk/data/websvc/ftp/dropzone/ftpfxit${env}/xmlt/stage/*
do

	# this if ensures we are only processing files so that we skip over the folders
	if [ -f $file ]; then

		# define a variable called output_name with a hardcoded output folder path and using the name of the file currently being processed
		# note: ${file##*/} strips the path out of the variable file so that only the file name remains
		export output_name=/disk/data/websvc/ftp/dropzone/ftpfxit${env}/xmlt/stage/processed/${file##*/}
	
		# this while loop reads one line at a time from the file currently being processed by the for loop
		while IFS= read -r line
		do
			# use cut to extract the charcaters from position 1 to 4 from the current line and save to a variable called trans_cd
			export trans_cd=$(echo "$line" | cut -c 1-4)
			case $trans_cd in
				1001)
					# 1001 = header record
					# save the line to a variable called header
					export header=$line
					;;
				1002)
					# 1002 = summary record
					# use cut to extract the characters from position 1006 to 1008 from the current line and save to a variable called version_nbr (last 3 digits only)
					export version_nbr=$(echo "$line" | cut -c 1006-1008)
					# use cut to extract everything preceeding the version number field (which starts in position 1000) and save it to a variable called line_wo_ver
					export line_wo_ver=$(echo "$line" | cut -c 1-999)
					write_line 		#call write_line function
					;;
				1004)
					# 1004 = slip record
					# use cut to extract the characters from position 1614 to 1616 from the current line and save to a variable called version_nbr (last 3 digits only)
					export version_nbr=$(echo "$line" | cut -c 1614-1616)
					# use cut to extract everything preceeding the version number field (which starts in position 1608) and save it to a variable called line_wo_ver
					export line_wo_ver=$(echo "$line" | cut -c 1-1607)
					write_line 		# call write_line function
					;;
				1005)
					# 1005 = controlling person record
					# use cut to extract the characters from position 1112 to 1120 from the current line and save to a variable called version_nbr (last 3 digits only)
					export version_nbr=$(echo "$line" | cut -c 1118-1120)
					# use cut to extract everything preceeding the version number field (which starts in position 1112) and save it to a variable called line_wo_ver
					export line_wo_ver=$(echo "$line" | cut -c 1-1111)
					write_line 		# call write_line function
					;;
				1007)
					# 1007 = trailer record
					# save the line to a variable called trailer
					export trailer=$line
					;;
				*)
					# if trans_cd is not one of the above values display it on the console and abort script with return code 1
					echo "Aborting - invalid trans-cd: " $trans_cd
					exit 1
					;;
			esac
		done < "$file"
	
		# this will loop thru all of the files we have just created in the while loop to add the header and trailer records to each one
		for split_file in ${output_name}.V*
		do
			# use sed to insert the header record before the first line
			sed -i "1s/^/$header\n/" $split_file
			# add the trailer to the end of the file
			echo "$trailer" >> $split_file
			# move split file to outbound folder where it will be picked up by SSC's daemon
			mv $split_file /disk/data/websvc/ftp/dropzone/ftpfxit${env}/xmlt/outbound/unprocessed
		done
	
		# move unsplit file to archive folder so we don't process it again next time
		mv $file /disk/data/websvc/ftp/dropzone/ftpfxit${env}/xmlt/stage/archive
		
	fi

done

exit 0
