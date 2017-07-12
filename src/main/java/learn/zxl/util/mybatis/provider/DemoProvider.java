package learn.zxl.util.mybatis.provider;

import org.apache.ibatis.mapping.MappedStatement;

import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.entity.EntityTable;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;

public class DemoProvider extends MapperTemplate {

	public DemoProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
		super(mapperClass, mapperHelper);
	}

	public String insertRecordInit(MappedStatement ms) {
		final Class<?> entityClass = getEntityClass(ms);
		EntityTable table = EntityHelper.getEntityTable(entityClass);
		// 开始拼sql
		StringBuilder sql = new StringBuilder();
		sql.append("insert into ");
		sql.append(table.getName());
		sql.append("(");
		boolean first = true;
		for (EntityColumn column : table.getEntityClassColumns()) {
			if (column.isId()) {
				continue;
			}
			if (!first) {
				sql.append(",");
			}
			sql.append(column.getColumn());
			first = false;
		}
		sql.append(") values(");
		first = true;
		for (EntityColumn column : table.getEntityClassColumns()) {
			if (column.isId()) {
				continue;
			}
			if (!first) {
				sql.append(",");
			}
			if ("createdDate".equalsIgnoreCase(column.getProperty())) {
				sql.append(" now()");
			} else {
				sql.append("#{").append(column.getProperty()).append("}");
			}
			first = false;
		}
		sql.append(")");

		return sql.toString();
	}
	
	public String selectNextAutoIncrementId(MappedStatement ms){
		final Class<?> entityClass = getEntityClass(ms);
		EntityTable table = EntityHelper.getEntityTable(entityClass);
		return String.format("select AUTO_INCREMENT from INFORMATION_SCHEMA.TABLES where TABLE_NAME='%s'", table.getName());
	}
}
