package etiquetas;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class TituloStyelTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	@Override
	public int doStartTag() throws JspException {
		
		JspWriter writer = pageContext.getOut();
		
		try {
			writer.print("Hola a todos");
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		return super.doStartTag();
	}

}
