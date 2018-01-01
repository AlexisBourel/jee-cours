package compteClient.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import compteClient.beans.Client;
import compteClient.jdbc.JDBC;
/**
 * Servlet implementation class ValidationOK
 */
@WebServlet("/Confirmation")
public class Confirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String BDPATH = "jdbc:mysql://localhost:3306/promo_lps2";
	private final static String DBUSER = "admin";
	private final static String DBPASSWORD = "admin";
	
	private static Connection connection;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirmation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/confirmation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//inserer ici l'ajout a la bdd
		
		String utilisateur =request.getParameter("utilisateur");
		String password =request.getParameter("password");
		String mail =request.getParameter("mail");
		String questionSecrete =request.getParameter("questionSecrete");
		String reponseSecrete =request.getParameter("reponseSecrete");
		String nom =request.getParameter("nom");
		String prenom =request.getParameter("prenom");
		
		
		Client newClient = new Client();
		newClient.setUtilisateur(request.getParameter("utilisateur"));
		newClient.setPassword(request.getParameter("password"));
		newClient.setMail(request.getParameter("mail"));
		newClient.setqSecrete(request.getParameter("qSecrete"));
		newClient.setrSecrete(request.getParameter("rSecrete"));
		newClient.setNom(request.getParameter("nom"));
		newClient.setPrenom(request.getParameter("prenom"));
		newClient.setAdresse(request.getParameter("adresse"));
		newClient.setCp(request.getParameter("cp"));
		newClient.setVille(request.getParameter("ville"));
		
		JDBC jdbc =new JDBC();
		
		try {
			jdbc.connecter();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			jdbc.insertData(utilisateur, password, mail, questionSecrete, reponseSecrete, nom, prenom);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		try {
//			connection.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		request.setAttribute("client", newClient);
		getServletContext().getRequestDispatcher("/confirmation.jsp").forward(request, response);
	}

}
