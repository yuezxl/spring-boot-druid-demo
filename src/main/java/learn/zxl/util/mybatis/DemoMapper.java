package learn.zxl.util.mybatis;

import learn.zxl.util.mybatis.provider.DemoProvider;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface DemoMapper<T> extends Mapper<T>, MySqlMapper<T> {
	
	@Options(useGeneratedKeys = true, keyProperty = "id")
	@InsertProvider(type = DemoProvider.class, method = "dynamicSQL")
	int insertRecordInit(T record);
	
	/**
	 * 查询改表下一个自增ID
	 * 
	 * @param record
	 * @return
	 */
	@SelectProvider(method = "dynamicSQL", type = DemoProvider.class)
	long selectNextAutoIncrementId(T record);
}
