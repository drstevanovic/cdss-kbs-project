package ftn.uns.ac.rs.util;

import org.drools.core.reteoo.RuleTerminalNodeLeftTuple;
import org.kie.api.definition.rule.Rule;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DebugAgendaEventListener extends DefaultAgendaEventListener {
    // private final static Logger LOGGER = Logger.getLogger(DebugAgendaEventListener.class.getName());
    private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DebugAgendaEventListener.class.getName());

    private List<Object> firedRules = new ArrayList<>();

    public List<Object> getFiredRules() {
        return firedRules;
    }

    public void setFiredRules(List<Object> firedRules) {
        this.firedRules = firedRules;
    }

    public void deleteFiredRules() {
        firedRules.clear();
    }

    @Override
    public void afterMatchFired(AfterMatchFiredEvent event) {

        Rule rule = event.getMatch().getRule();
        int salience = ((RuleTerminalNodeLeftTuple)event.getMatch()).getSalience();

        LOGGER.info("Rule fired: " + rule.getName() + ", " + event);
        firedRules.add(rule.getName() + " with probability " + salience + "%");
        firedRules.add(rule);

    }
}
