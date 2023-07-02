package modelo;

import java.sql.Connection;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import db.MysqlConexion;
import entidades.Subject;
import interfaces.SubjectInterface;

public class SubjectModel implements SubjectInterface{
	
	
	@Override
	public int createSubject(Subject subject) {
		
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String sql = "INSERT INTO subject VALUES(null, ?, ?, ?, ?)";
			psm = cn.prepareStatement(sql);
			psm.setString(1, subject.getCode());
			psm.setString(2, subject.getName());
			psm.setString(3, subject.getLevel());
			psm.setString(4, subject.getTeacher());
			
			value = psm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psm != null) psm.close();
				if (cn != null) cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return value;
	}
	
	@Override
	public List<Subject> listSubject() {
		List<Subject> listSubject = new ArrayList<Subject>();
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			cn = MysqlConexion.getConexion();
			String sql = "SELECT * FROM Subject";
			psm = cn.prepareStatement(sql);
			rs = psm.executeQuery();
			
			while (rs.next()) {
				Subject subj = new Subject();
				subj.setId(rs.getString("idSubject"));
				subj.setCode(rs.getString("code"));
				subj.setName(rs.getString("name"));
				subj.setLevel(rs.getString("level"));
				subj.setTeacher(rs.getString("teacher"));
				listSubject.add(subj);
			}
			
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (psm != null) psm.close();
				if (cn != null) cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return listSubject;
		
	}
	
	@Override
	public Subject getSubject(String id) {
		
		Subject subject = null;
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String sql = "SELECT * FROM subject where idSubject=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1, id);
			rs = psm.executeQuery();
			
			if (rs.next() ) {
				subject = new Subject();
				subject.setId(rs.getString("idSubject"));
				subject.setCode(rs.getString("code"));
				subject.setName(rs.getString("name"));
				subject.setLevel(rs.getString("level"));
				subject.setTeacher(rs.getString("teacher"));
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				if (rs != null) rs.close();
				if (psm != null) psm.close();
				if (cn != null) cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return subject;
		
	}
	
	@Override
	public int editSubject(Subject subject) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String sql = "UPDATE subject SET(code=?, name=?, level=?, teacher? WHERE idSubject=?)";
			
//			UPDATE subject
//			SET 
//				CODE = 'ABC',
//				NAME = 'Programación Orientada a Objetos II',
//				LEVEL = '5',
//				teacher = 'JP'
//			WHERE idSubject = 8;
			
			psm = cn.prepareStatement(sql);
			psm.setString(1, subject.getCode());
			psm.setString(2, subject.getName());
			psm.setString(3, subject.getLevel());
			psm.setString(4, subject.getTeacher());
			psm.setString(5, subject.getId());
			
			value = psm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psm != null) psm.close();
				if (cn != null) cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return value;
	}
	
	@Override
	public int deleteSubject(String id) {
		
		int value = 0;
		Connection cn = null;
		PreparedStatement psm = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String sql = "DELETE FROM subject WHERE idSubject=?";
			psm = cn.prepareStatement(sql);
			psm.setString(1,  id);
			value = psm.executeUpdate();
			
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (psm != null) psm.close();
				if (cn != null) cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return value;
	}

}
