package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.websocket.Session;

import library.LibraryConnectDb;
import model.bean.Data;

public class DataDao {
	private LibraryConnectDb connectDb;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	public DataDao() {
		connectDb = new LibraryConnectDb();
	}
	public Data getList(){
		Data objD = null;
		conn = connectDb.getConnectMySql();
		String sql = "SELECT * FROM b1";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()){
				objD = new Data(rs.getInt("Temp"), rs.getInt("Humi"),rs.getBoolean("Door"),rs.getInt("Light_Room"),rs.getInt("Light_Porch"),rs.getInt("FirePlace"),rs.getInt("FadeLed"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return objD;
	}
	public int updateList(int temp, int humi){
		int result = 0;
		String sql = "UPDATE b1 SET Temp=?, Humi=? WHERE ID_B1 = 1";
		conn = connectDb.getConnectMySql();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, temp);
			pst.setInt(2, humi);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public int updateFade(int fade){
		int result = 0;
		String sql = "UPDATE b1 SET FadeLed=? WHERE ID_B1 = 1";
		conn = connectDb.getConnectMySql();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, fade);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public int updateLed(boolean led){
		int result = 0;
		String sql = "UPDATE b1 SET Door=? WHERE ID_B1 = 1";
		conn = connectDb.getConnectMySql();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setBoolean(1, led);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
