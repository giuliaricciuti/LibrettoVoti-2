package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.libretto.model.Voto;

//anziché il main (come fatto in prova) è utile creare una classe di metodi che 
	//mi faccia accedere ai dati. in gergo una classe così si chiama "DAO"
	
public class VotoDAO {
	
	//in genere i metodi implementati qui sono i CRUD (create-read-update-delete)
	//noi non usiamo molto delete, ma list. in ogni caso i metodi di reading li useremo
	// più dei write
	
	
	public List<Voto> listVoti(){
		//quando il model ha bisogno chiama questo metodo che farà la query al db

		try {
			Connection conn = DBConnect.getConnection();
			Statement st = conn.createStatement();
			
			String sql = "SELECT corso, punti, data\n"
					+ "FROM voto" ;
			
			ResultSet res = st.executeQuery(sql);
			
			List <Voto> voti = new ArrayList<>();
			
			while (res.next()) {
				String corso = res.getString("corso");
				int punti = res.getInt("punti");
				LocalDate data = res.getDate("data").toLocalDate();
				Voto v = new Voto (corso, punti, data);
				voti.add(v);
			}
			
			conn.close();
			return voti;			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public void createVoto (Voto v) {
		//passa un voto e lo inserisce nel db
		//preso da console in alto a dx in sequel pro
		
		/* SBAGLIATO FAREString sql = "INSERT INTO `voto` (`corso`, `punti`, `data`) "+ "VALUES ('"+v.getCorso()+"', "
		 * +v.getPunti()+", '"+v.getDataEsame()+"');";
		 * metto dei punti interrogativi, perché è illeggibile e in più sbagliato
		 * in quanto l'utente potrebbe inserire che vuole. devo usare un preparedstatement
		 * anziché statement. metto dei punti interrogativi al posto dei parametri e preparedstatement:
		 */
		
		String sql = " INSERT INTO `voto` (`corso`, `punti`, `data`)" +"VALUES ('?', '?', '?');";
		
		
			try {
				Connection conn = DBConnect.getConnection();
				//anzichè uno statemet creo un preparedstatement che vuole come parametri
				//un template di query
				PreparedStatement st = conn.prepareStatement(sql);
				
				//assegno ora i valori ai parametri
				st.setString(1, v.getCorso());
				st.setInt(2, v.getPunti());
				//st.setDate(3, v.getDataEsame() );
				st.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				
	}
	
	public Voto readVoto (String corso) {
		return null;
		//restituisce un singolo voto
	}
	
	public List<Voto> searchVotoPuntiMaggiore(int punti){
		return null;
		//ricerca in base au punti
	}
}
