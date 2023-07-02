package etiquetas;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class ImagenTag extends TagSupport {
	
	private String nombre = "";
	public int doStartTag() throws JspException {
		try {
			
			JspWriter out = pageContext.getOut();
			out.println("<img src='img/" + nombre + ".jpg");
		} catch (IOException e) {
			throw new JspException("Error: " + e.getMessage());
		}
		
		return super.doStartTag();
	}

}
