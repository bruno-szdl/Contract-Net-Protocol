import astra.core.Module;
import astra.formula.Predicate;
import astra.term.Funct;
import astra.term.Term;

import java.util.List;
import java.util.Map;

public class Check extends Module {
    @TERM
    public int count(Funct query) {
        Predicate formula = new Predicate(query.functor(), query.terms());
        List<Map<Integer,Term>> bindings = agent.queryAll(formula);
        if (bindings != null) return bindings.size();
        return 0;
    }
}