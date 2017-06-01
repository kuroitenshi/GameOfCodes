package com.misys.gameofcodes.utility;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.atlassian.event.api.EventPublisher;
import com.atlassian.httpclient.apache.httpcomponents.DefaultHttpClient;
import com.atlassian.httpclient.api.Request;
import com.atlassian.httpclient.api.factory.HttpClientOptions;
import com.atlassian.httpclient.spi.ThreadLocalContextManagers;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.auth.BasicHttpAuthenticationHandler;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClient;
import com.atlassian.jira.rest.client.internal.async.AtlassianHttpClientDecorator;
import com.atlassian.jira.rest.client.internal.async.DisposableHttpClient;
import com.atlassian.sal.api.ApplicationProperties;
import com.atlassian.util.concurrent.Effect;

public class RestClientUtility {

	private JiraRestClient jiraRestClient;
	private final String username;
	private final String password;
	private int socketTimeout;
	private TimeUnit timeunit;
	private final URI jiraServerUri;

	public RestClientUtility(int socketTimeout, TimeUnit timeunit) throws URISyntaxException {
		username = "jpbautis";
		password = "Welcome@99";
		jiraServerUri = new URI("https://almtools/jira/");
		this.socketTimeout = socketTimeout;
		this.timeunit = timeunit;

	}

	/**
	 * Returns created JiraRestClient
	 * @return JiraRestClient
	 */
	public JiraRestClient getJiraRestClient() {
				
		jiraRestClient = new AsynchronousJiraRestClient(jiraServerUri, this.getDisosableHttpClient()); 
		return jiraRestClient;
	}

	/**
	 * Creates disposableHttpClient from defaultHttpClient
	 * @return DisposableHttpClient
	 */
	public DisposableHttpClient getDisosableHttpClient(){
		 
		final DefaultHttpClient<Object> defaultHttpClient = getHttpClient();
		return new AtlassianHttpClientDecorator(defaultHttpClient){

			@Override
			public void destroy() throws Exception {
				defaultHttpClient.destroy();
				
			}
			
		};
	}
	/**
	 * Creates defaultHttpClient from default jira server URI, auth options, event publisher and restClientApplicationProperties
	 * @return
	 */
	public DefaultHttpClient<Object> getHttpClient() {
		
		final DefaultHttpClient<Object> defaultHttpClient = new DefaultHttpClient<>(new NoOpEventPublisher(),
				new RestClientApplicationProperties(jiraServerUri), ThreadLocalContextManagers.noop(),
				this.getClientOptions());
		return defaultHttpClient;
	}

	/**
	 * Creates basicAuthenticationHandler from username and password
	 * @return
	 */
	public BasicHttpAuthenticationHandler getAuthenticationHandler() {

		return new BasicHttpAuthenticationHandler(this.username, this.password);
	}

	/**
	 * Sets authentication handlers and socket timeouts
	 * @return
	 */
	public HttpClientOptions getClientOptions() {
		HttpClientOptions options = new HttpClientOptions();
		options.setConnectionTimeout(this.socketTimeout, this.timeunit);
		options.setSocketTimeout(this.socketTimeout, this.timeunit);
		options.setRequestPreparer(new Effect<Request>(){

			@Override
			public void apply(Request a) {
				BasicHttpAuthenticationHandler authHandler = new BasicHttpAuthenticationHandler(username, password);
				authHandler.configure(a);
				
			}
			
		});

		return options;
	}

	private static class NoOpEventPublisher implements EventPublisher {

		@Override
		public void publish(Object o) {
		}

		@Override
		public void register(Object o) {
		}

		@Override
		public void unregister(Object o) {
		}

		@Override
		public void unregisterAll() {
		}
	}

	/**
	 * These properties are used to present JRJC as a User-Agent during http
	 * requests.
	 */
	private static class RestClientApplicationProperties implements ApplicationProperties {

		private final String baseUrl;

		private RestClientApplicationProperties(URI jiraURI) {
			this.baseUrl = jiraURI.getPath();
		}

		@Override
		public String getBaseUrl() {
			return baseUrl;
		}

		@Override
		public String getDisplayName() {
			return "Atlassian JIRA Rest Java Client";
		}

		@Override
		public String getVersion() {
			return MavenUtils.getVersion("com.atlassian.jira", "jira-rest-java-com.atlassian.jira.rest.client");
		}

		@Override
		public Date getBuildDate() {
			// TODO implement using MavenUtils, JRJC-123
			throw new UnsupportedOperationException();
		}

		@Override
		public String getBuildNumber() {
			// TODO implement using MavenUtils, JRJC-123
			return String.valueOf(0);
		}

		@Override
		public File getHomeDirectory() {
			return new File(".");
		}

		@Override
		public String getPropertyValue(final String s) {
			throw new UnsupportedOperationException("Not implemented");
		}
	}
	private static final class MavenUtils {
	
	    private static final String UNKNOWN_VERSION = "unknown";

	    static String getVersion(String groupId, String artifactId) {
	      final Properties props = new Properties();
	      InputStream resourceAsStream = null;
	      try {
	        resourceAsStream = MavenUtils.class.getResourceAsStream(String
	            .format("/META-INF/maven/%s/%s/pom.properties", groupId, artifactId));
	        props.load(resourceAsStream);
	        return props.getProperty("version", UNKNOWN_VERSION);
	      } catch (Exception e) {
	     
	    	  return UNKNOWN_VERSION;
	      } finally {
	        if (resourceAsStream != null) {
	          try {
	            resourceAsStream.close();
	          } catch (IOException ioe) {
	            // ignore
	          }
	        }
	      }
	    }
	  }
	public URI getJiraServerUri() {
		return jiraServerUri;
	}


}
