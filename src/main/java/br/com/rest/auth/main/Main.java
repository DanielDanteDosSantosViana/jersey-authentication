package br.com.rest.auth.main;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ext.ContextResolver;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

/**
 * Main class.
 *
 */
public class Main {
	  public static HttpServer startServer(String ip,String porta) {
	    	System.out.println("API REST - Iniciando ...");
	        return GrizzlyHttpServerFactory.createHttpServer(URI.create("http://"+ip+":"+porta+"/rest/"),createApp());
	    }

	    /**
	     * Metodo Main.
	     * @param args
	     */
	    public static void main(String[] args) {
	        
	    	if(args.length!=2){
	    		
	    	      System.err.println("Erro na chamada do comando.");
	              System.err.println("Uso: java -jar NOME_DO_JAR [IP_SERVIDOR] [PORTA]");
	              System.exit(1);
	    	}
	    	
	    	final HttpServer server = startServer(args[0],args[1]);
	    	
	        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	            @Override
	            public void run() {
	        		System.out.println("Aplicacao saindo ...");
	                server.shutdown();
	            }
	        }, "shutdownHook"));
	        
	    	try {
	    		server.start();
	    		System.out.println(String.format("applicação API-REST está rodando. Acesse  ", args[0]+":"+args[1]+"rest/"));
	    		System.out.println("Press CTRL^C to exit..");
	    	    Thread.currentThread().join();
	    	    } catch (Exception ioe) {
	    	    	server.shutdown();
	    	        System.err.println(ioe);
	    	    }
	     
	    			
	    		
	    }
	    
	    
	public static ResourceConfig createApp() {
        return new ResourceConfig().
                packages("br.com.rest.auth").
                register(createMoxyJsonResolver()).
                register(RolesAllowedDynamicFeature.class);
        }
    
    public static ContextResolver<MoxyJsonConfig> createMoxyJsonResolver() {
        final MoxyJsonConfig moxyJsonConfig = new MoxyJsonConfig();
        Map<String, String> namespacePrefixMapper = new HashMap<String, String>(1);
        namespacePrefixMapper.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        moxyJsonConfig.setNamespacePrefixMapper(namespacePrefixMapper).setNamespaceSeparator(':');
        
        return moxyJsonConfig.resolver();
    }


}

