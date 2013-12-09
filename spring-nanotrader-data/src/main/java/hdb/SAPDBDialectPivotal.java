package hdb;

import org.hibernate.annotations.common.util.StringHelper;
import java.math.BigDecimal;
import java.sql.Types;

import org.hibernate.dialect.SAPDBDialect;

public class SAPDBDialectPivotal extends SAPDBDialect {
	
	public SAPDBDialectPivotal() {
		super();
		//registerColumnType( BigDecimal, "double" );
		registerColumnType( Types.NUMERIC, "double precision" );

	}
	
	public String getAddForeignKeyConstraintString(
			String constraintName, 
			String[] foreignKey, 
			String referencedTable, 
			String[] primaryKey, boolean referencesPrimaryKey
	) {
		StringBuffer res = new StringBuffer(30)
			.append(" ADD CONSTRAINT ")
			.append(constraintName)
			.append(" foreign key ")
			.append(" (")
			.append( StringHelper.join(", ", foreignKey) )
			.append(") references ")
			.append(referencedTable);
		
		if(!referencesPrimaryKey) {
			res.append(" (")
			   .append( StringHelper.join(", ", primaryKey) )
			   .append(')');
		}
			
		return res.toString();
	}

	public boolean dropConstraints() {
		return true;
	}


}
