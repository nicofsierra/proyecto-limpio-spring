package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorOperacion {
	
	@RequestMapping("/operacion/{metodo}/{oper1}/{oper2}")
	public ModelAndView opera (@PathVariable String metodo,
							   @PathVariable Integer oper1,
							   @PathVariable Integer oper2 )
	{
		ModelMap modelo = new ModelMap();
		
		modelo.put("operando1", oper1);
		modelo.put("operando2", oper2);
		modelo.put("texto", metodo);
		
		switch (metodo) {
		case "sumar" : modelo.put("resultado",oper1+oper2);
					   break;
		case "restar" : modelo.put("resultado",oper1-oper2);
		                break;
		case "multiplicar" : modelo.put("resultado",oper1*oper2);
		   					break;
		case "dividir" : try 
					     { 
							modelo.put("resultado",oper1/oper2); 
					     }
						 catch(ArithmeticException excepcion)
						 {	
							 modelo.put("error",excepcion);
							 return new ModelAndView("erroroperacion",modelo);
						 }
							
		}
        return new ModelAndView("operacion",modelo);

		
	}

}
