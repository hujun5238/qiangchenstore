package com.zzz.testweb.system.db;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.zzz.testweb.system.constants.TestConstants;

public class BaseDaoImpl  extends SqlMapClientDaoSupport implements IBaseDao, Serializable {
	private static final long serialVersionUID = 5298707454262075629L;
	protected static final Logger log = LoggerFactory.getLogger(BaseDaoImpl.class);
	
	/**
	 * 鍙栧緱缁撴灉闆嗕釜鏁�
	 * 
	 * @param ob
	 *            Object
	 * @return Integer
	 */
	public Integer getSum(Object ob) {
		
		String sql_id = (String) ((Map) ob).get(TestConstants.IBATIS_SQL_ID);
		Integer sum = (Integer) getSqlMapClientTemplate().queryForObject(sql_id, ob);
		return sum;
	}
	/**
	 * 鍙栧緱鍗曚釜缁撴灉
	 * 
	 * @param ob
	 *            Object
	 * @return Object
	 */
	public Object get(Object ob) {
		String sql_id = (String) ((Map) ob).get(TestConstants.IBATIS_SQL_ID);
		Object resultObject = getSqlMapClientTemplate().queryForObject(sql_id, ob);
		return resultObject;
	}
	
	/**
	 * 鍙栧緱鍗曚釜缁撴灉
	 * 
	 * @param ob
	 *            Object
	 * @param sqlId
	 * 			  String
	 * @return Object
	 */
	public Object get(Object ob, String sqlId) {
		Object resultObject = getSqlMapClientTemplate().queryForObject(sqlId, ob);
		return resultObject;
	}

	/**
	 * 鍙栧緱澶氫釜缁撴灉
	 * 
	 * @param ob
	 *            Object
	 * @return List
	 */
	public List getList(Object ob) {		
		//SqlMapExecutorDelegate delegate=((ExtendedSqlMapClient)(getSqlMapClientTemplate().getSqlMapClient())).getDelegate(); 
		String sql_id = (String) ((Map) ob).get(TestConstants.IBATIS_SQL_ID);
		List list = (List) getSqlMapClientTemplate().queryForList(sql_id, ob);
		return list;
	}
	
	/**
	 * 鍙栧緱澶氫釜缁撴灉
	 * 
	 * @param ob
	 *            Object
	 * @return List
	 */
	public List getList(Object ob, String sqlId) {
		List list = (List) getSqlMapClientTemplate().queryForList(sqlId, ob);
		return list;
	}

	/**
	 * 鎻掑叆涓�缁勬暟鎹�
	 * 
	 * @param ob
	 *            Object
	 * @return
	 */
	public void save(final Object ob) {
		String sql_id = (String) ((Map) ob).get(TestConstants.IBATIS_SQL_ID);
		getSqlMapClientTemplate().insert(sql_id, ob);
	}
	
	/**
	 * 鎻掑叆涓�缁勬暟鎹�
	 * 
	 * @param ob
	 *            Object
	 * @param sqlId
	 * 			  String
	 * @return
	 */
	public void save(Object ob, String sqlId) {
		getSqlMapClientTemplate().insert(sqlId, ob);
	}
	
	/**
	 * 鎻掑叆涓�缁勬暟鎹苟杩斿洖涓�涓嚜澧為暱id
	 * 
	 * @param ob
	 *            Object
	 * @return int
	 */
	public int saveBackId(Object ob){
		String sql_id = (String) ((Map) ob).get(TestConstants.IBATIS_SQL_ID);
		return Integer.parseInt(String.valueOf(getSqlMapClientTemplate().insert(sql_id, ob)));
		 
	}
	
	/**
	 * 鎻掑叆涓�缁勬暟鎹苟杩斿洖涓�涓嚜澧為暱id
	 * 
	 * @param ob
	 *            Object
	 * @param sqlId
	 * 			  String  
	 * @return int
	 */
	public int saveBackId(Object ob, String sqlId){
		return Integer.parseInt(String.valueOf(getSqlMapClientTemplate().insert(sqlId, ob)));
		 
	}
	
	/**
	 * 鐢ㄦ壒澶勭悊鎻掑叆涓�缁勬暟鎹�
	 * 
	 * @param list
	 *            List
	 * @param sqlId
	 * 			  String         
	 * @return 
	 */
	public void saveAll(final List<Map<String, Object>> list, final String sqlId) {
		
		// 鎵ц鍥炶皟  
		getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			// 瀹炵幇鍥炶皟鎺ュ彛  
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				// 寮�濮嬫壒澶勭悊  
				executor.startBatch();
				for (Map<String, Object> map : list) {
					// 鎻掑叆鎿嶄綔  
					executor.insert(sqlId, map);
				}  
				// 鎵ц鎵瑰鐞�  
				executor.executeBatch();
				return null;
			}
		});
	}
	
	/**
	 * 鐢ㄦ壒澶勭悊鎻掑叆涓�缁勬暟鎹�
	 * 
	 * @param list
	 *            List
	 * @param sqlId
	 * 			  String         
	 * @return 
	 */
	public void saveAllObjs(final List list, final String sqlId) {
		
		// 鎵ц鍥炶皟  
		getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			// 瀹炵幇鍥炶皟鎺ュ彛  
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				// 寮�濮嬫壒澶勭悊  
				executor.startBatch();
				for (Object obj : list) {
					// 鎻掑叆鎿嶄綔  
					executor.insert(sqlId, obj);
				}  
				// 鎵ц鎵瑰鐞�  
				executor.executeBatch();
				return null;
			}
		});
	}
	
	/**
	 * 鐢ㄦ壒澶勭悊鏇存柊涓�缁勬暟鎹�
	 * 
	 * @param list
	 *            List
	 * @param sqlId
	 * 			  String         
	 * @return 
	 */
	public void updateAllObjs(final List list, final String sqlId) {
		
		// 鎵ц鍥炶皟  
		getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			// 瀹炵幇鍥炶皟鎺ュ彛  
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				// 寮�濮嬫壒澶勭悊  
				executor.startBatch();
				for (Object obj : list) {
					// 鏇存柊鎿嶄綔  
					executor.update(sqlId, obj);
				}  
				// 鎵ц鎵瑰鐞�  
				executor.executeBatch();
				return null;
			}
		});
	}
	
	/**
	 * 鏇存柊涓�缁勬暟鎹�
	 * 
	 * @param ob
	 *            Object
	 * @return int
	 */
	public int update(Object ob) {
		String sql_id = (String) ((Map) ob).get(TestConstants.IBATIS_SQL_ID);
		return getSqlMapClientTemplate().update(sql_id, ob);
	}
	
	/**
	 * 鏇存柊涓�缁勬暟鎹�
	 * 
	 * @param ob
	 *            Object
	 * @param sqlId
	 *            String
	 * @return int
	 */
	public int update(Object ob, String sqlId) {
		return getSqlMapClientTemplate().update(sqlId, ob);
	}

	/**
	 * 鍒犻櫎涓�缁勬暟鎹�
	 * 
	 * @param ob
	 *            Object
	 * @return int
	 */
	public int remove(Object ob) {
		String sql_id = (String) ((Map) ob).get(TestConstants.IBATIS_SQL_ID);
		return getSqlMapClientTemplate().update(sql_id, ob);
	}
	
	/**
	 * 鍒犻櫎涓�缁勬暟鎹�
	 * 
	 * @param ob
	 *            Object
	 * @param sqlId
	 *            String
	 * @return int
	 */
	public int remove(Object ob, String sqlId) {
		return getSqlMapClientTemplate().update(sqlId, ob);
	}

	/**
	 * 鍙栧緱绯荤粺鏃堕棿
	 * 
	 * @param
	 * @return String
	 */
	public String getSYSDate() {
		return (String) getSqlMapClientTemplate().queryForObject("BINOLCMINC99.getSYSDate", null);
	}
	
	/**
	 * 鍙栧緱绯荤粺鏃堕棿(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @param
	 * @return String
	 */
	public String getSYSDateTime() {
		return (String) getSqlMapClientTemplate().queryForObject("BINOLCMINC99.getSYSDateTime", null);
	}
	
	/**
	 * 鍙栧緱绯荤粺鏃堕棿(骞存湀鏃�)
	 * 
	 * @param
	 * @return String
	 */
	public String getDateYMD() {
		return (String) getSqlMapClientTemplate().queryForObject("BINOLCMINC99.getDateYMD", null);
	}

	/**
	 * 鎵ц涓�涓瓨鍌ㄨ繃绋嬶紝鏌ヨ骞跺彇寰椾竴涓粨鏋滈泦
	 * 
	 * @param ob
	 * 			   Object 
	 * @return Object
	 */
	public Object getProcs(Object ob) {
		String sql_id = (String) ((Map) ob).get(TestConstants.IBATIS_SQL_ID);
		Object resultObject = getSqlMapClientTemplate().queryForObject(sql_id, ob);
		return resultObject;
	}
	
	/**
	 * 鎵ц涓�涓瓨鍌ㄨ繃绋嬶紝鏌ヨ骞跺彇寰楀涓粨鏋滈泦
	 * 
	 * @param ob
	 * 			   Object 
	 * @return Object
	 */
	public List getProcsList(Object ob) {
		String sql_id = (String) ((Map) ob).get(TestConstants.IBATIS_SQL_ID);
		List list = (List) getSqlMapClientTemplate().queryForList(sql_id, ob);
		return list;
	}
	

	/**
	 * 鎵ц涓�涓瓨鍌ㄨ繃绋嬶紝鏇存柊DB鏁版嵁
	 * 
	 * @param ob
	 * 			   Object 
	 * @return String
	 */
	public Object updateProcs(Object ob) {
		String sql_id = (String) ((Map) ob).get(TestConstants.IBATIS_SQL_ID);
		getSqlMapClientTemplate().queryForObject(sql_id, ob);
		return ob;
	}
	/**
	 * 鐢ㄦ壒澶勭悊鏇存柊涓�缁勬暟鎹�
	 * 
	 * @param list
	 *            List
	 * @param sqlId
	 * 			  String         
	 * @return 
	 */
	public void updateAll(final List<Map<String, Object>> list, final String sqlId) {
		
		// 鎵ц鍥炶皟  
		getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			// 瀹炵幇鍥炶皟鎺ュ彛  
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				// 寮�濮嬫壒澶勭悊  
				executor.startBatch();
				for (Map<String, Object> map : list) {
					// 鏇存柊鎿嶄綔  
					executor.update(sqlId, map);
				}  
				// 鎵ц鎵瑰鐞�  
				executor.executeBatch();
				return null;
			}
		});
	}
	
	/**
	 * 鐢ㄦ壒澶勭悊鍒犻櫎涓�缁勬暟鎹�
	 * 
	 * @param list
	 *            List
	 * @param sqlId
	 * 			  String         
	 * @return 
	 */
	public void deleteAll(final List<Map<String, Object>> list, final String sqlId) {
		
		// 鎵ц鍥炶皟  
		getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			// 瀹炵幇鍥炶皟鎺ュ彛  
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				// 寮�濮嬫壒澶勭悊  
				executor.startBatch();
				for (Map<String, Object> map : list) {
					// 鍒犻櫎鎿嶄綔  
					executor.delete(sqlId, map);
				}  
				// 鎵ц鎵瑰鐞�  
				executor.executeBatch();
				return null;
			}
		});
	}
	

}
