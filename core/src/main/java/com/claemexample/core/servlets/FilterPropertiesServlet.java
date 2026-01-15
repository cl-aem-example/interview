package com.claemexample.core.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_METHODS;
import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_PATHS;

@Component(
        immediate = true,
        service = Servlet.class,
        property = {
                SLING_SERVLET_PATHS + "=/bin/canadalife/filter/properties",
                SLING_SERVLET_METHODS + "=GET"
        }
)
public class FilterPropertiesServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {


        String[] exList = {
                "jcr:created",
                "jcr:createdBy",
                "jcr:lastModified",
                "jcr:lastModifiedBy",
                "jcr:primaryType",
                "jcr:mixinTypes",
                "jcr:uuid",
                "cq:lastModified",
                "cq:lastModifiedBy",
                "cq:lastReplicated",
                "cq:lastReplicatedBy",
                "cq:lastReplicationAction"
        };

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = new HashMap<>();

        String path = request.getParameter("path");
        Resource resource = request.getResourceResolver().getResource(path);
        ValueMap properties = resource.getValueMap();

        Set<String> propSet = new HashSet<>(Arrays.asList(exList));

        Map<String, Object> props = new HashMap<>();
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            String key = entry.getKey();
            if (!propSet.contains(key)) {
                Object value = entry.getValue();

                if (value != null && value.getClass().isArray()) {
                    if (value instanceof String[]) {
                        props.put(key, Arrays.asList((String[]) value));
                    } else if (value instanceof Long[]) {
                        props.put(key, Arrays.asList((Long[]) value));
                    } else if (value instanceof Integer[]) {
                        props.put(key, Arrays.asList((Integer[]) value));
                    } else if (value instanceof Boolean[]) {
                        props.put(key, Arrays.asList((Boolean[]) value));
                    } else if (value instanceof Double[]) {
                        props.put(key, Arrays.asList((Double[]) value));
                    } else {
                        props.put(key, value.toString());
                    }
                } else {
                    props.put(key, value);
                }
            }
        }

        result.put("data", props);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);

        PrintWriter writer = response.getWriter();
        writer.write(objectMapper.writeValueAsString(result));
        writer.flush();
    }
}

