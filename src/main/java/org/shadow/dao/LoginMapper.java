package org.shadow.dao;

import org.apache.ibatis.annotations.Param;

public interface LoginMapper {

	public int verify(@Param("name")String name, @Param("password")String password);
}
