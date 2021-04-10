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


public class Controller extends ASTRAClass {
	public Controller() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"Controller", new int[] {33,9,33,33},
			new GoalEvent('+',
				new Goal(
					new Predicate("iniciateServiceMsg", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Controller", new int[] {33,32,37,5},
				new Statement[] {
					new ModuleCall("messaging",
						"Controller", new int[] {34,8,34,75},
						new Predicate("installService", new Term[] {
							Primitive.newPrimitive("local"),
							Primitive.newPrimitive("astra.messaging.LocalMQService")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Messaging) intention.getModule("Controller","messaging")).installService(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("messaging",
						"Controller", new int[] {35,8,35,39},
						new Predicate("startService", new Term[] {
							Primitive.newPrimitive("local")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Messaging) intention.getModule("Controller","messaging")).startService(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("system",
						"Controller", new int[] {36,8,36,50},
						new Predicate("createAgent", new Term[] {
							Primitive.newPrimitive("register"),
							Primitive.newPrimitive("Register")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Controller","system")).createAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Controller", new int[] {43,9,45,25},
			new GoalEvent('+',
				new Goal(
					new Predicate("createAgents", new Term[] {})
				)
			),
			new AND(
				new Predicate("nRestaurants", new Term[] {
					new Variable(Type.INTEGER, "R",false)
				}),
				new Predicate("nClients", new Term[] {
					new Variable(Type.INTEGER, "C",false)
				})
			),
			new Block(
				"Controller", new int[] {45,24,61,5},
				new Statement[] {
					new ModuleCall("console",
						"Controller", new int[] {46,12,46,42},
						new Predicate("println", new Term[] {
							new ModuleTerm("system", Type.STRING,
								new Predicate("name", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.System) intention.getModule("Controller","system")).name(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.System) visitor.agent().getModule("Controller","system")).name(
										);
									}
								}
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Controller","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Declaration(
						new Variable(Type.INTEGER, "X"),
						"Controller", new int[] {47,12,61,5},
						Primitive.newPrimitive(1)
					),
					new Assignment(
						new Variable(Type.INTEGER, "X"),
						"Controller", new int[] {48,12,61,5},
						Primitive.newPrimitive(1)
					),
					new While(
						"Controller", new int[] {49,12,61,5},
						new Comparison("<=",
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "R")
						),
						new Block(
							"Controller", new int[] {49,26,53,13},
							new Statement[] {
								new ModuleCall("system",
									"Controller", new int[] {50,16,50,65},
									new Predicate("createAgent", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("restaurant_"),
											new Variable(Type.INTEGER, "X")
										),
										Primitive.newPrimitive("Restaurant")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.System) intention.getModule("Controller","system")).createAgent(
												(java.lang.String) intention.evaluate(predicate.getTerm(0)),
												(java.lang.String) intention.evaluate(predicate.getTerm(1))
											);
										}
									}
								),
								new ModuleCall("console",
									"Controller", new int[] {51,16,51,65},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Created restaurant_"),
											Operator.newOperator('+',
												new Variable(Type.INTEGER, "X"),
												Primitive.newPrimitive(" Agent")
											)
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Controller","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Assignment(
									new Variable(Type.INTEGER, "X"),
									"Controller", new int[] {52,16,53,13},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "X"),
										Primitive.newPrimitive(1)
									)
								)
							}
						)
					),
					new ModuleCall("system",
						"Controller", new int[] {54,12,54,28},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(100)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Controller","system")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Assignment(
						new Variable(Type.INTEGER, "X"),
						"Controller", new int[] {55,12,61,5},
						Primitive.newPrimitive(1)
					),
					new While(
						"Controller", new int[] {56,12,61,5},
						new Comparison("<=",
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "C")
						),
						new Block(
							"Controller", new int[] {56,26,60,9},
							new Statement[] {
								new ModuleCall("system",
									"Controller", new int[] {57,16,57,57},
									new Predicate("createAgent", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("client_"),
											new Variable(Type.INTEGER, "X")
										),
										Primitive.newPrimitive("Client")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.System) intention.getModule("Controller","system")).createAgent(
												(java.lang.String) intention.evaluate(predicate.getTerm(0)),
												(java.lang.String) intention.evaluate(predicate.getTerm(1))
											);
										}
									}
								),
								new ModuleCall("console",
									"Controller", new int[] {58,16,58,61},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Created client_"),
											Operator.newOperator('+',
												new Variable(Type.INTEGER, "X"),
												Primitive.newPrimitive(" Agent")
											)
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Controller","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Assignment(
									new Variable(Type.INTEGER, "X"),
									"Controller", new int[] {59,16,60,9},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "X"),
										Primitive.newPrimitive(1)
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Controller", new int[] {63,9,63,62},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("placedAll", new Term[] {
					new Variable(Type.STRING, "S",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Controller", new int[] {63,61,66,5},
				new Statement[] {
					new ModuleCall("console",
						"Controller", new int[] {64,8,64,67},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("---------------------- Received "),
								new Variable(Type.STRING, "sender")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Controller","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new BeliefUpdate('+',
						"Controller", new int[] {65,8,66,5},
						new Predicate("nClientsPlaced", new Term[] {
							new Variable(Type.STRING, "sender")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Controller", new int[] {68,9,69,27},
			new GoalEvent('+',
				new Goal(
					new Predicate("checkAllClientsPlaced", new Term[] {})
				)
			),
			new Predicate("nClients", new Term[] {
				new Variable(Type.INTEGER, "NC",false)
			}),
			new Block(
				"Controller", new int[] {69,26,80,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "NCP"),
						"Controller", new int[] {70,8,80,5},
						new ModuleTerm("check", Type.INTEGER,
							new Predicate("count", new Term[] {
								new Funct("nClientsPlaced", new Term[] {
									new Variable(Type.STRING, "S",false)
								})
							}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((Check) intention.getModule("Controller","check")).count(
										(astra.term.Funct) intention.evaluate(predicate.getTerm(0))
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((Check) visitor.agent().getModule("Controller","check")).count(
										(astra.term.Funct) visitor.evaluate(predicate.getTerm(0))
									);
								}
							}
						)
					),
					new ModuleCall("console",
						"Controller", new int[] {72,8,72,28},
						new Predicate("println", new Term[] {
							new Variable(Type.INTEGER, "NCP")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Controller","console")).println(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new If(
						"Controller", new int[] {73,8,80,5},
						new Comparison("==",
							new Variable(Type.INTEGER, "NC"),
							new Variable(Type.INTEGER, "NCP")
						),
						new Block(
							"Controller", new int[] {73,22,76,9},
							new Statement[] {
								new ModuleCall("console",
									"Controller", new int[] {74,12,74,84},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("---------------------- CNP 1 ------------------------")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Controller","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new ModuleCall("system",
									"Controller", new int[] {75,12,75,25},
									new Predicate("exit", new Term[] {}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.System) intention.getModule("Controller","system")).exit(
											);
										}
									}
								)
							}
						),
						new Block(
							"Controller", new int[] {76,15,80,5},
							new Statement[] {
								new ModuleCall("system",
									"Controller", new int[] {77,12,77,26},
									new Predicate("sleep", new Term[] {
										Primitive.newPrimitive(1)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return false;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.System) intention.getModule("Controller","system")).sleep(
												(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Subgoal(
									"Controller", new int[] {78,12,79,9},
									new Goal(
										new Predicate("checkAllClientsPlaced", new Term[] {})
									)
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
			new Predicate("nClients", new Term[] {
				Primitive.newPrimitive(200)
			})
		);
		agent.initialize(
			new Predicate("nRestaurants", new Term[] {
				Primitive.newPrimitive(50)
			})
		);
		agent.initialize(
			new Predicate("nClientsPlaced", new Term[] {
				Primitive.newPrimitive(0)
			})
		);
		agent.initialize(
			new Goal(
				new Predicate("iniciateServiceMsg", new Term[] {})
			)
		);
		agent.initialize(
			new Goal(
				new Predicate("createAgents", new Term[] {})
			)
		);
		agent.initialize(
			new Goal(
				new Predicate("checkAllClientsPlaced", new Term[] {})
			)
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("messaging",astra.lang.Messaging.class,agent);
		fragment.addModule("console",astra.lang.Console.class,agent);
		fragment.addModule("system",astra.lang.System.class,agent);
		fragment.addModule("debug",astra.lang.Debug.class,agent);
		fragment.addModule("check",Check.class,agent);
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
			astra.core.Agent agent = new Controller().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
