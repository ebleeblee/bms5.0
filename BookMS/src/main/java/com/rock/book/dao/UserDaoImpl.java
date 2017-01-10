package com.rock.book.dao;

import java.util.List;


import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.rock.book.model.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public List<User> getUsers() {
		// 모든 사원 정보 가져오기
		return getSqlSession().selectList("userInfoDao.getAllUsers"); //매핑 네임스페이스.select id
	}

	

}
