/**
 * GENERATED CODE - DO NOT CHANGE
 */

import astra.core.*;
import astra.execution.*;
import astra.event.*;
import astra.messaging.*;
import astra.formula.*;
import astra.lang.*;
import astra.statement.*;
import astra.term.*;
import astra.type.*;
import astra.tr.*;
import astra.reasoner.util.*;


public class DeliveryMan extends ASTRAClass {
	public DeliveryMan() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"DeliveryMan", new int[] {14,9,15,9},
			new GoalEvent('+',
				new Goal(
					new Predicate("init", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"DeliveryMan", new int[] {15,8,25,5},
				new Statement[] {
					new ModuleCall("console",
						"DeliveryMan", new int[] {16,8,16,29},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("HI")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("DeliveryMan","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("debug",
						"DeliveryMan", new int[] {17,8,17,27},
						new Predicate("dumpBeliefs", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Debug) intention.getModule("DeliveryMan","debug")).dumpBeliefs(
								);
							}
						}
					),
					new While(
						"DeliveryMan", new int[] {18,8,25,5},
						new Predicate("typesOfFood", new Term[] {
							new Variable(Type.INTEGER, "X",false)
						}),
						new Block(
							"DeliveryMan", new int[] {18,34,21,9},
							new Statement[] {
								new BeliefUpdate('-',
									"DeliveryMan", new int[] {19,12,21,9},
									new Predicate("typesOfFood", new Term[] {
										new Variable(Type.INTEGER, "X")
									})
								),
								new ModuleCall("debug",
									"DeliveryMan", new int[] {20,12,20,31},
									new Predicate("dumpBeliefs", new Term[] {}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Debug) intention.getModule("DeliveryMan","debug")).dumpBeliefs(
											);
										}
									}
								)
							}
						)
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("typesOfFood", new Term[] {
				Primitive.newPrimitive(1)
			})
		);
		agent.initialize(
			new Predicate("typesOfFood", new Term[] {
				Primitive.newPrimitive(2)
			})
		);
		agent.initialize(
			new Goal(
				new Predicate("init", new Term[] {})
			)
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("console",astra.lang.Console.class,agent);
		fragment.addModule("debug",astra.lang.Debug.class,agent);
		return fragment;
	}

	public static void main(String[] args) {
		Scheduler.setStrategy(new AdaptiveSchedulerStrategy());
		ListTerm argList = new ListTerm();
		for (String arg: args) {
			argList.add(Primitive.newPrimitive(arg));
		}

		String name = java.lang.System.getProperty("astra.name", "main");
		try {
			astra.core.Agent agent = new DeliveryMan().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
