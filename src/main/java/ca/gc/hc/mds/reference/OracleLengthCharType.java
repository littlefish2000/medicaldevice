package ca.gc.hc.mds.reference;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StringType;
import org.hibernate.usertype.UserType;

public class OracleLengthCharType implements UserType {

	public OracleLengthCharType() {
		System.out.println("OracleFixedLengthCharType constructor");
	}

	public int[] sqlTypes() {
		return new int[] { Types.CHAR };
	}

	public Class<String> returnedClass() {
		return String.class;
	}

	public boolean equals(Object x, Object y) {
		return (x == y) || (x != null && y != null && (x.equals(y)));
	}

	@Override
	public Object nullSafeGet(ResultSet inResultSet, String[] names, SessionImplementor sessionIm, Object o)
			throws HibernateException, SQLException {

		String val = StringType.INSTANCE.nullSafeGet(inResultSet, names[0], sessionIm);
		//System.out.println("From nullSafeGet method valu is " + val);
		return val == null ? null : StringUtils.trim(val);
	}

	@Override
	public void nullSafeSet(PreparedStatement inPreparedStatement, Object o, int i, SessionImplementor arg3)
			throws HibernateException, SQLException {
		String val = (String) o;
		// Get the delegatingStmt object from DBCP connection pool
		// PreparedStatement object.
		org.apache.commons.dbcp.DelegatingStatement delgatingStmt = (org.apache.commons.dbcp.DelegatingStatement) inPreparedStatement;
		// Get OraclePreparedStatement object using deletatingStatement object.

		oracle.jdbc.OraclePreparedStatement oraclePreparedStmpt = (oracle.jdbc.OraclePreparedStatement) delgatingStmt
				.getInnermostDelegate();
		// Call setFixedCHAR method, by passing string type value .
		oraclePreparedStmpt.setFixedCHAR(i, val);
	}

	public Object deepCopy(Object o) {
		if (o == null) {
			return null;
		}
		return new String(((String) o));
	}

	public boolean isMutable() {
		return false;
	}

	public Object assemble(Serializable cached, Object owner) {
		return cached;
	}

	public Serializable disassemble(Object value) {
		return (Serializable) value;
	}

	public Object replace(Object original, Object target, Object owner) {
		return original;
	}

	public int hashCode(Object obj) {
		return obj.hashCode();
	}

}
