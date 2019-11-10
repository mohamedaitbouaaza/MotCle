package web;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.IMetierCatalogue ; 

@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private IMetierCatalogue metier ; 
    @Override
    public void init() throws ServletException {
    	metier = new MetierImpl();
       
    }  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mc = request.getParameter ("motCle");
		ProduitModel mod = new ProduitModel ();
		mod.setMotCle(mc);
		List <Produit> prods = metier.getProduitsParMc(mc);
		mod.setProduits(prods);
		request.setAttribute("modele", mod);
		request.getRequestDispatcher("ProduitsView.jsp").forward(request, response);
	}

}
