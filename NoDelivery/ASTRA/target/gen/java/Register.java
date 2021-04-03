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


public class Register extends ASTRAClass {
	public Register() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"Register", new int[] {14,9,14,18},
			new GoalEvent('+',
				new Goal(
					new Predicate("init", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Register", new int[] {14,17,25,5},
				new Statement[] {
					new ModuleCall("df",
						"Register", new int[] {15,8,15,28},
						new Predicate("register", new Term[] {
							Primitive.newPrimitive("pizza")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((Df) intention.getModule("Register","df")).register(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("df",
						"Register", new int[] {16,8,16,32},
						new Predicate("register", new Term[] {
							Primitive.newPrimitive("hamburger")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((Df) intention.getModule("Register","df")).register(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("df",
						"Register", new int[] {17,8,17,30},
						new Predicate("register", new Term[] {
							Primitive.newPrimitive("burrito")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((Df) intention.getModule("Register","df")).register(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("df",
						"Register", new int[] {18,8,18,29},
						new Predicate("register", new Term[] {
							Primitive.newPrimitive("pastel")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((Df) intention.getModule("Register","df")).register(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("df",
						"Register", new int[] {19,8,19,28},
						new Predicate("register", new Term[] {
							Primitive.newPrimitive("pasta")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((Df) intention.getModule("Register","df")).register(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("df",
						"Register", new int[] {20,8,20,28},
						new Predicate("register", new Term[] {
							Primitive.newPrimitive("sushi")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((Df) intention.getModule("Register","df")).register(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("df",
						"Register", new int[] {21,8,21,30},
						new Predicate("register", new Term[] {
							Primitive.newPrimitive("seafood")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((Df) intention.getModule("Register","df")).register(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("df",
						"Register", new int[] {22,8,22,29},
						new Predicate("register", new Term[] {
							Primitive.newPrimitive("hotdog")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((Df) intention.getModule("Register","df")).register(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("df",
						"Register", new int[] {23,8,23,28},
						new Predicate("register", new Term[] {
							Primitive.newPrimitive("salad")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((Df) intention.getModule("Register","df")).register(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("df",
						"Register", new int[] {24,8,24,28},
						new Predicate("register", new Term[] {
							Primitive.newPrimitive("sfiha")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((Df) intention.getModule("Register","df")).register(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Register", new int[] {27,9,27,78},
			new MessageEvent(
				new Performative("cfp"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("sendCFP", new Term[] {
					new Variable(Type.STRING, "OrderId",false),
					new Variable(Type.INTEGER, "X",false),
					new Variable(Type.INTEGER, "Y",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Register", new int[] {27,77,29,9},
				new Statement[] {
					new Send("Register", new int[] {28,12,28,53},
						new Performative("refuse"),
						new Variable(Type.STRING, "sender"),
						new Predicate("sendRefuse", new Term[] {
							new Variable(Type.STRING, "OrderId")
						})
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Goal(
				new Predicate("init", new Term[] {})
			)
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("df",Df.class,agent);
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
			astra.core.Agent agent = new Register().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
