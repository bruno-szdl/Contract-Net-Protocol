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
			"Controller", new int[] {30,9,30,33},
			new GoalEvent('+',
				new Goal(
					new Predicate("iniciateServiceMsg", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Controller", new int[] {30,32,34,5},
				new Statement[] {
					new ModuleCall("messaging",
						"Controller", new int[] {31,8,31,75},
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
						"Controller", new int[] {32,8,32,39},
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
						"Controller", new int[] {33,8,33,50},
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
			"Controller", new int[] {40,9,43,25},
			new GoalEvent('+',
				new Goal(
					new Predicate("createAgents", new Term[] {})
				)
			),
			new AND(
				new Predicate("nDeliveryMen", new Term[] {
					new Variable(Type.INTEGER, "D",false)
				}),
				new AND(
					new Predicate("nRestaurants", new Term[] {
						new Variable(Type.INTEGER, "R",false)
					}),
					new Predicate("nClients", new Term[] {
						new Variable(Type.INTEGER, "C",false)
					})
				)
			),
			new Block(
				"Controller", new int[] {43,24,64,5},
				new Statement[] {
					new ModuleCall("console",
						"Controller", new int[] {44,12,44,42},
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
						"Controller", new int[] {45,12,64,5},
						Primitive.newPrimitive(1)
					),
					new While(
						"Controller", new int[] {46,12,64,5},
						new Comparison("<=",
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "D")
						),
						new Block(
							"Controller", new int[] {46,26,50,13},
							new Statement[] {
								new ModuleCall("system",
									"Controller", new int[] {47,16,47,68},
									new Predicate("createAgent", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("delivery_man_"),
											new Variable(Type.INTEGER, "X")
										),
										Primitive.newPrimitive("DeliveryMan")
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
									"Controller", new int[] {48,16,48,67},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Created delivery_man_"),
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
									"Controller", new int[] {49,16,50,13},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "X"),
										Primitive.newPrimitive(1)
									)
								)
							}
						)
					),
					new Assignment(
						new Variable(Type.INTEGER, "X"),
						"Controller", new int[] {51,12,64,5},
						Primitive.newPrimitive(1)
					),
					new While(
						"Controller", new int[] {52,12,64,5},
						new Comparison("<=",
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "R")
						),
						new Block(
							"Controller", new int[] {52,26,56,13},
							new Statement[] {
								new ModuleCall("system",
									"Controller", new int[] {53,16,53,65},
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
									"Controller", new int[] {54,16,54,65},
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
									"Controller", new int[] {55,16,56,13},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "X"),
										Primitive.newPrimitive(1)
									)
								)
							}
						)
					),
					new ModuleCall("system",
						"Controller", new int[] {57,12,57,29},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(1000)
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
						"Controller", new int[] {58,12,64,5},
						Primitive.newPrimitive(1)
					),
					new While(
						"Controller", new int[] {59,12,64,5},
						new Comparison("<=",
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "C")
						),
						new Block(
							"Controller", new int[] {59,26,63,9},
							new Statement[] {
								new ModuleCall("system",
									"Controller", new int[] {60,16,60,57},
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
									"Controller", new int[] {61,16,61,61},
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
									"Controller", new int[] {62,16,63,9},
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
			"Controller", new int[] {66,9,66,62},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("placedAll", new Term[] {
					new Variable(Type.STRING, "S",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Controller", new int[] {66,61,71,5},
				new Statement[] {
					new ModuleCall("console",
						"Controller", new int[] {67,8,67,67},
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
					new Query(
						"Controller", new int[] {68,8,68,36},
						new Predicate("nClientsPlaced", new Term[] {
							new Variable(Type.INTEGER, "N",false)
						})
					),
					new SpecialBeliefUpdate(
						"Controller", new int[] {69,8,71,5},
						new Predicate("nClientsPlaced", new Term[] {
							Operator.newOperator('+',
								new Variable(Type.INTEGER, "N"),
								Primitive.newPrimitive(1)
							)
						})
					),
					new Subgoal(
						"Controller", new int[] {70,8,71,5},
						new Goal(
							new Predicate("checkAllClientsPlaced", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Controller", new int[] {73,9,74,27},
			new GoalEvent('+',
				new Goal(
					new Predicate("checkAllClientsPlaced", new Term[] {})
				)
			),
			new Predicate("nClients", new Term[] {
				new Variable(Type.INTEGER, "NC",false)
			}),
			new Block(
				"Controller", new int[] {74,26,79,5},
				new Statement[] {
					new Query(
						"Controller", new int[] {75,8,75,38},
						new Predicate("nClientsPlaced", new Term[] {
							new Variable(Type.INTEGER, "NCP",false)
						})
					),
					new If(
						"Controller", new int[] {76,8,79,5},
						new Comparison("==",
							new Variable(Type.INTEGER, "NC"),
							new Variable(Type.INTEGER, "NCP")
						),
						new Block(
							"Controller", new int[] {76,22,78,9},
							new Statement[] {
								new ModuleCall("console",
									"Controller", new int[] {77,12,77,84},
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
			new Predicate("nDeliveryMen", new Term[] {
				Primitive.newPrimitive(1)
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
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("messaging",astra.lang.Messaging.class,agent);
		fragment.addModule("console",astra.lang.Console.class,agent);
		fragment.addModule("system",astra.lang.System.class,agent);
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
