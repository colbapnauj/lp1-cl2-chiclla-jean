package db;

import dao.DAOFactory;
import interfaces.AuthInterface;
import interfaces.EstudianteInterface;
import interfaces.ProfesoresInterface;
import interfaces.SessionInterface;
import interfaces.SubjectInterface;
import modelo.AuthModel;
import modelo.EstudianteModel;
import modelo.ProfesoresModel;
import modelo.SessionModel;
import modelo.SubjectModel;

public class MySqlDAOFactory extends DAOFactory {
	
	@Override
	public EstudianteInterface getEstudiante() {
		return new EstudianteModel();
	}

	@Override
	public SubjectInterface getSubject() {
		return new SubjectModel();
	}

	@Override
	public ProfesoresInterface getProfesores() {
		return new ProfesoresModel();
	}

	@Override
	public AuthInterface getAuth() {
		return new AuthModel();
	}

	@Override
	public SessionInterface getSession() {
		return new SessionModel();
	}

}
