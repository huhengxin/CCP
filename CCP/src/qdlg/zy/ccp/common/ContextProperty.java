package qdlg.zy.ccp.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 自定义PropertyPlaceholderConfigurer返回properties内容
 * @author Administrator
 *
 */
public class ContextProperty extends PropertyPlaceholderConfigurer {

	private final static Logger logger = LoggerFactory
			.getLogger(ContextProperty.class);
	private static Map<String, Object> ctxPropertiesMap;

	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		logger.info("====System Properties====:" + props);
		ctxPropertiesMap = new HashMap<String, Object>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			ctxPropertiesMap.put(keyStr, value);
		}
	}

	public static Object getProperty(String name) {
		return ctxPropertiesMap.get(name);
	}

}