package com.werner.dao.role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.werner.dao.BaseDao;
import com.werner.pojo.Role;

public class RoleDaoImpl implements RoleDao{
	
	//獲取角色列表
		public List<Role> getRoleList(Connection connection) throws SQLException {
			PreparedStatement pstm = null;
			ResultSet rs = null;
			ArrayList<Role> roleList = new ArrayList<Role>();
			
			if(connection != null) {
				String sql = "select * from smbms_role";
				Object[] params = {};
				
				rs = BaseDao.execute(connection, pstm, rs, sql, params);
				
				while(rs.next()) {
					Role _role = new Role();
					_role.setId(rs.getInt("id"));				
					_role.setRoleCode(rs.getString("roleCode"));
					_role.setRoleName(rs.getString("roleName"));
					roleList.add(_role);
				}
				BaseDao.closeResources(null, pstm, rs);			
			}
			return roleList;
		}
}
