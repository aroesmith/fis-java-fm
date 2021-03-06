package fis.front;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

public class ScriptDirective implements TemplateDirectiveModel {

	private FISResource fisRes;

	public ScriptDirective(FISResource fisRes) {
		super();
		this.fisRes = fisRes;
	}

	public void execute(Environment env, Map params, TemplateModel[] loopVars,   
            TemplateDirectiveBody body) throws TemplateException, IOException {
        if (body != null) {     
            StringWriter sOut = new StringWriter();    
            body.render(sOut);   
            
            String script = sOut.getBuffer().toString();
            fisRes.addScriptPool(script);
        } 
		
	}
	

}
