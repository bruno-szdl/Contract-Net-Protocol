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
			"Controller", new int[] {40,9,40,33},
			new GoalEvent('+',
				new Goal(
					new Predicate("iniciateServiceMsg", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Controller", new int[] {40,32,44,5},
				new Statement[] {
					new ModuleCall("messaging",
						"Controller", new int[] {41,8,41,75},
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
						"Controller", new int[] {42,8,42,39},
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
						"Controller", new int[] {43,8,43,50},
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
			"Controller", new int[] {50,9,53,25},
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
				"Controller", new int[] {53,24,74,5},
				new Statement[] {
					new ModuleCall("console",
						"Controller", new int[] {54,12,54,42},
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
						"Controller", new int[] {55,12,74,5},
						Primitive.newPrimitive(1)
					),
					new While(
						"Controller", new int[] {56,12,74,5},
						new Comparison("<=",
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "D")
						),
						new Block(
							"Controller", new int[] {56,26,60,13},
							new Statement[] {
								new ModuleCall("system",
									"Controller", new int[] {57,16,57,68},
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
									"Controller", new int[] {58,16,58,67},
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
									"Controller", new int[] {59,16,60,13},
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
						"Controller", new int[] {61,12,74,5},
						Primitive.newPrimitive(1)
					),
					new While(
						"Controller", new int[] {62,12,74,5},
						new Comparison("<=",
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "R")
						),
						new Block(
							"Controller", new int[] {62,26,66,13},
							new Statement[] {
								new ModuleCall("system",
									"Controller", new int[] {63,16,63,65},
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
									"Controller", new int[] {64,16,64,65},
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
									"Controller", new int[] {65,16,66,13},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "X"),
										Primitive.newPrimitive(1)
									)
								)
							}
						)
					),
					new ModuleCall("system",
						"Controller", new int[] {67,12,67,28},
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
						"Controller", new int[] {68,12,74,5},
						Primitive.newPrimitive(1)
					),
					new While(
						"Controller", new int[] {69,12,74,5},
						new Comparison("<=",
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "C")
						),
						new Block(
							"Controller", new int[] {69,26,73,9},
							new Statement[] {
								new ModuleCall("system",
									"Controller", new int[] {70,16,70,57},
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
									"Controller", new int[] {71,16,71,61},
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
									"Controller", new int[] {72,16,73,9},
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
			"Controller", new int[] {76,9,76,62},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("placedAll", new Term[] {
					new Variable(Type.STRING, "S",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Controller", new int[] {76,61,79,5},
				new Statement[] {
					new ModuleCall("console",
						"Controller", new int[] {77,8,77,79},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("---------------------- Received placed from "),
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
						"Controller", new int[] {78,8,79,5},
						new Predicate("nClientsPlaced", new Term[] {
							new Variable(Type.STRING, "sender")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Controller", new int[] {81,9,82,27},
			new GoalEvent('+',
				new Goal(
					new Predicate("checkAllClientsPlaced", new Term[] {})
				)
			),
			new Predicate("nClients", new Term[] {
				new Variable(Type.INTEGER, "NC",false)
			}),
			new Block(
				"Controller", new int[] {82,26,93,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "NCP"),
						"Controller", new int[] {83,8,93,5},
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
						"Controller", new int[] {85,8,85,37},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("NCP "),
								new Variable(Type.INTEGER, "NCP")
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
					new If(
						"Controller", new int[] {86,8,93,5},
						new Comparison("==",
							new Variable(Type.INTEGER, "NC"),
							new Variable(Type.INTEGER, "NCP")
						),
						new Block(
							"Controller", new int[] {86,22,89,9},
							new Statement[] {
								new ModuleCall("console",
									"Controller", new int[] {87,12,87,84},
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
								new Subgoal(
									"Controller", new int[] {88,12,89,9},
									new Goal(
										new Predicate("checkAllClientsFinished", new Term[] {})
									)
								)
							}
						),
						new Block(
							"Controller", new int[] {89,15,93,5},
							new Statement[] {
								new ModuleCall("system",
									"Controller", new int[] {90,12,90,26},
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
									"Controller", new int[] {91,12,92,9},
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
		addRule(new Rule(
			"Controller", new int[] {95,9,95,64},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("finishedAll", new Term[] {
					new Variable(Type.STRING, "S",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Controller", new int[] {95,63,98,5},
				new Statement[] {
					new ModuleCall("console",
						"Controller", new int[] {96,8,96,81},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("---------------------- Received finished from "),
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
						"Controller", new int[] {97,8,98,5},
						new Predicate("nClientsFinished", new Term[] {
							new Variable(Type.STRING, "sender")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Controller", new int[] {100,9,101,27},
			new GoalEvent('+',
				new Goal(
					new Predicate("checkAllClientsFinished", new Term[] {})
				)
			),
			new Predicate("nClients", new Term[] {
				new Variable(Type.INTEGER, "NC",false)
			}),
			new Block(
				"Controller", new int[] {101,26,112,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "NCF"),
						"Controller", new int[] {102,8,112,5},
						new ModuleTerm("check", Type.INTEGER,
							new Predicate("count", new Term[] {
								new Funct("nClientsFinished", new Term[] {
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
						"Controller", new int[] {104,8,104,37},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("NCF "),
								new Variable(Type.INTEGER, "NCF")
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
					new If(
						"Controller", new int[] {105,8,112,5},
						new Comparison("==",
							new Variable(Type.INTEGER, "NC"),
							new Variable(Type.INTEGER, "NCF")
						),
						new Block(
							"Controller", new int[] {105,22,108,9},
							new Statement[] {
								new ModuleCall("console",
									"Controller", new int[] {106,12,106,84},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("---------------------- CNP 2 ------------------------")
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
									"Controller", new int[] {107,12,107,25},
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
							"Controller", new int[] {108,15,112,5},
							new Statement[] {
								new ModuleCall("system",
									"Controller", new int[] {109,12,109,28},
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
								new Subgoal(
									"Controller", new int[] {110,12,111,9},
									new Goal(
										new Predicate("checkAllClientsFinished", new Term[] {})
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
				Primitive.newPrimitive(50)
			})
		);
		agent.initialize(
			new Predicate("nRestaurants", new Term[] {
				Primitive.newPrimitive(50)
			})
		);
		agent.initialize(
			new Predicate("nDeliveryMen", new Term[] {
				Primitive.newPrimitive(10)
			})
		);
		agent.initialize(
			new Predicate("nClientsPlaced", new Term[] {
				Primitive.newPrimitive(0)
			})
		);
		agent.initialize(
			new Predicate("nClientsFinished", new Term[] {
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
