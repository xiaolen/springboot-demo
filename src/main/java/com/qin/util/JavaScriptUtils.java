package com.qin.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


@Slf4j
public class JavaScriptUtils {

    private static Map<String, ScriptEngine> scriptMap = new HashMap();
    private static final String MEDIA_TYPE = "application/javascript";
	
    /**
     * 调用js函数
     * @param fileName
     * @param funName
     * @param args
     * @return
     */
    public static String invoker(String fileName, String funName, Object ...args) {
        String result = null;
        try{
            if(StringUtils.isNotEmpty(fileName)){
                if(null == scriptMap.get(fileName)){
                    ScriptEngineManager manager = new ScriptEngineManager();
                    ScriptEngine engine = manager.getEngineByMimeType(MEDIA_TYPE);
                    PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
                    Resource[] resources = patternResolver.getResources(fileName);
                    if (resources != null && resources.length > 0) {
                        InputStreamReader inputStreamReader = new InputStreamReader(resources[0].getInputStream());
                        engine.eval(inputStreamReader);
                        inputStreamReader.close();
                        scriptMap.put(fileName,engine);
                    }
                    
                }
                ScriptEngine engine = scriptMap.get(fileName);
                if(engine instanceof Invocable) {
                    Invocable invoke = (Invocable)engine;
                    result = (String)invoke.invokeFunction(funName,args);
                }
            }
            return result;
        }catch (Exception ex){
            log.error("==>[{}]-[{}]密码加密出错了", fileName, funName, ex);
            return "";
        }
    }
}
