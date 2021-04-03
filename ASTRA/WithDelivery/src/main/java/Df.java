import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import astra.core.ActionParam;
import astra.core.Module;
import astra.term.ListTerm;
import astra.term.Primitive;

public class Df extends Module {
    private static Map<String, List<String>> registry = new TreeMap<String, List<String>>();
    
    @ACTION
    public boolean register(String category) {
        List<String> list = registry.get(category);
        if (list == null) {
            list = new LinkedList<String>();
            registry.put(category, list);
        }

        list.add(agent.name());
        return true;
    }

    @ACTION
    public boolean search(String category,ActionParam<ListTerm> participants) {
        ListTerm listTerm = new ListTerm();
        List<String> list = registry.get(category);
        if (list == null) throw new RuntimeException("Category: ''" +category + "'' does not exist");
        for (String name : list) {
            listTerm.add(Primitive.newPrimitive(name));
        }
        participants.set(listTerm);
        return true;
    }
}