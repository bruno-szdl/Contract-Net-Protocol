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


public class Client extends ASTRAClass {
	public Client() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"Client", new int[] {69,9,70,41},
			new GoalEvent('+',
				new Goal(
					new Predicate("init", new Term[] {})
				)
			),
			new AND(
				new Predicate("nOrders", new Term[] {
					new Variable(Type.INTEGER, "N",false)
				}),
				new Predicate("typesOfFood", new Term[] {
					new Variable(Type.INTEGER, "T",false)
				})
			),
			new Block(
				"Client", new int[] {70,40,95,9},
				new Statement[] {
					new Declaration(
						new Variable(Type.STRING, "Name"),
						"Client", new int[] {71,8,95,9},
						new ModuleTerm("system", Type.STRING,
							new Predicate("name", new Term[] {}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.System) intention.getModule("Client","system")).name(
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.System) visitor.agent().getModule("Client","system")).name(
									);
								}
							}
						)
					),
					new BeliefUpdate('+',
						"Client", new int[] {72,8,95,9},
						new Predicate("name", new Term[] {
							new Variable(Type.STRING, "Name")
						})
					),
					new ModuleCall("console",
						"Client", new int[] {73,8,73,43},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Hi, I am "),
								new Variable(Type.STRING, "Name")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Client","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("system",
						"Client", new int[] {74,8,74,24},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(100)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Client","system")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Declaration(
						new Variable(Type.LIST, "RestaurantsList"),
						"Client", new int[] {75,8,95,9},
						new ModuleTerm("system", Type.LIST,
							new Predicate("getAgentsOfType", new Term[] {
								Primitive.newPrimitive("Restaurant")
							}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.System) intention.getModule("Client","system")).getAgentsOfType(
										(java.lang.String) intention.evaluate(predicate.getTerm(0))
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.System) visitor.agent().getModule("Client","system")).getAgentsOfType(
										(java.lang.String) visitor.evaluate(predicate.getTerm(0))
									);
								}
							}
						)
					),
					new BeliefUpdate('+',
						"Client", new int[] {76,8,95,9},
						new Predicate("restaurants", new Term[] {
							new Variable(Type.LIST, "RestaurantsList")
						})
					),
					new ModuleCall("console",
						"Client", new int[] {77,8,77,40},
						new Predicate("println", new Term[] {
							new Variable(Type.LIST, "RestaurantsList")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Client","console")).println(
									(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Declaration(
						new Variable(Type.INTEGER, "X"),
						"Client", new int[] {78,8,95,9},
						Primitive.newPrimitive(0)
					),
					new While(
						"Client", new int[] {79,8,95,9},
						new Comparison("<",
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "N")
						),
						new Block(
							"Client", new int[] {79,20,85,13},
							new Statement[] {
								new Assignment(
									new Variable(Type.INTEGER, "X"),
									"Client", new int[] {80,12,85,13},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "X"),
										Primitive.newPrimitive(1)
									)
								),
								new Declaration(
									new Variable(Type.INTEGER, "R"),
									"Client", new int[] {81,12,85,13},
									Operator.newOperator('/',
										new ModuleTerm("math", Type.INTEGER,
											new Predicate("randomInt", new Term[] {}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((astra.lang.Math) intention.getModule("Client","math")).randomInt(
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.Math) visitor.agent().getModule("Client","math")).randomInt(
													);
												}
											}
										),
										Primitive.newPrimitive(225000000)
									)
								),
								new ModuleCall("console",
									"Client", new int[] {82,12,82,48},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("choosing food"),
											new Variable(Type.INTEGER, "R")
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Client","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Subgoal(
									"Client", new int[] {83,12,85,13},
									new Goal(
										new Predicate("chooseFood", new Term[] {
											new Variable(Type.INTEGER, "X"),
											new Variable(Type.INTEGER, "R")
										})
									)
								),
								new ModuleCall("system",
									"Client", new int[] {84,12,84,27},
									new Predicate("sleep", new Term[] {
										Primitive.newPrimitive(10)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return false;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.System) intention.getModule("Client","system")).sleep(
												(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								)
							}
						)
					),
					new ModuleCall("console",
						"Client", new int[] {86,8,86,56},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("I have finished choosing food")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Client","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new BeliefUpdate('-',
						"Client", new int[] {87,8,95,9},
						new Predicate("typesOfFood", new Term[] {
							new Variable(Type.INTEGER, "T")
						})
					),
					new Assignment(
						new Variable(Type.INTEGER, "X"),
						"Client", new int[] {88,8,95,9},
						Primitive.newPrimitive(0)
					),
					new While(
						"Client", new int[] {89,8,95,9},
						new Comparison("<",
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "T")
						),
						new Block(
							"Client", new int[] {89,20,92,13},
							new Statement[] {
								new BeliefUpdate('-',
									"Client", new int[] {90,12,92,13},
									new Predicate("food", new Term[] {
										new Variable(Type.INTEGER, "X"),
										new Variable(Type.STRING, "S",false)
									})
								),
								new Assignment(
									new Variable(Type.INTEGER, "X"),
									"Client", new int[] {91,12,92,13},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "X"),
										Primitive.newPrimitive(1)
									)
								)
							}
						)
					),
					new ModuleCall("debug",
						"Client", new int[] {93,8,93,27},
						new Predicate("dumpBeliefs", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Debug) intention.getModule("Client","debug")).dumpBeliefs(
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Client", new int[] {97,10,99,27},
			new GoalEvent('+',
				new Goal(
					new Predicate("chooseFood", new Term[] {
						new Variable(Type.INTEGER, "X",false),
						new Variable(Type.INTEGER, "R",false)
					})
				)
			),
			new AND(
				new Predicate("food", new Term[] {
					new Variable(Type.INTEGER, "R"),
					new Variable(Type.STRING, "F",false)
				}),
				new Predicate("name", new Term[] {
					new Variable(Type.STRING, "Name",false)
				})
			),
			new Block(
				"Client", new int[] {99,26,104,10},
				new Statement[] {
					new Declaration(
						new Variable(Type.STRING, "OrderId"),
						"Client", new int[] {100,13,104,10},
						Operator.newOperator('+',
							new Variable(Type.STRING, "Name"),
							Operator.newOperator('+',
								Primitive.newPrimitive(".Order_"),
								Operator.newOperator('+',
									new Variable(Type.INTEGER, "X"),
									Operator.newOperator('+',
										Primitive.newPrimitive("."),
										new Variable(Type.STRING, "F")
									)
								)
							)
						)
					),
					new BeliefUpdate('+',
						"Client", new int[] {101,13,104,10},
						new Predicate("orderId", new Term[] {
							new Variable(Type.STRING, "OrderId")
						})
					),
					new ModuleCall("console",
						"Client", new int[] {102,13,102,57},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("I want to order some "),
								new Variable(Type.STRING, "F")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Client","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Client", new int[] {103,13,104,10},
						new Goal(
							new Predicate("searchRestaurant", new Term[] {
								new Variable(Type.STRING, "OrderId")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Client", new int[] {107,9,107,25},
			new GoalEvent('+',
				new Goal(
					new Predicate("getLocation", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Client", new int[] {107,24,112,9},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "X"),
						"Client", new int[] {108,8,112,9},
						Operator.newOperator('/',
							new ModuleTerm("math", Type.INTEGER,
								new Predicate("randomInt", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Math) intention.getModule("Client","math")).randomInt(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Math) visitor.agent().getModule("Client","math")).randomInt(
										);
									}
								}
							),
							Primitive.newPrimitive(100000000)
						)
					),
					new Declaration(
						new Variable(Type.INTEGER, "Y"),
						"Client", new int[] {109,8,112,9},
						Operator.newOperator('/',
							new ModuleTerm("math", Type.INTEGER,
								new Predicate("randomInt", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Math) intention.getModule("Client","math")).randomInt(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Math) visitor.agent().getModule("Client","math")).randomInt(
										);
									}
								}
							),
							Primitive.newPrimitive(100000000)
						)
					),
					new BeliefUpdate('+',
						"Client", new int[] {110,8,112,9},
						new Predicate("location", new Term[] {
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "Y")
						})
					),
					new ModuleCall("console",
						"Client", new int[] {111,8,111,64},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("I am located in ("),
								Operator.newOperator('+',
									new Variable(Type.INTEGER, "X"),
									Operator.newOperator('+',
										Primitive.newPrimitive(", "),
										Operator.newOperator('+',
											new Variable(Type.INTEGER, "Y"),
											Primitive.newPrimitive(").")
										)
									)
								)
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Client","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Client", new int[] {114,9,114,25},
			new GoalEvent('+',
				new Goal(
					new Predicate("getStrategy", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Client", new int[] {114,24,117,9},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "S"),
						"Client", new int[] {115,8,117,9},
						Operator.newOperator('/',
							new ModuleTerm("math", Type.INTEGER,
								new Predicate("randomInt", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Math) intention.getModule("Client","math")).randomInt(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Math) visitor.agent().getModule("Client","math")).randomInt(
										);
									}
								}
							),
							Primitive.newPrimitive(1000000000)
						)
					),
					new ModuleCall("console",
						"Client", new int[] {116,8,116,38},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Strategy "),
								new Variable(Type.INTEGER, "S")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Client","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Client", new int[] {119,9,120,31},
			new GoalEvent('+',
				new Goal(
					new Predicate("searchRestaurant", new Term[] {
						new Variable(Type.STRING, "OrderId",false)
					})
				)
			),
			new Predicate("restaurants", new Term[] {
				new Variable(Type.LIST, "RL",false)
			}),
			new Block(
				"Client", new int[] {120,30,128,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "i"),
						"Client", new int[] {121,8,128,5},
						Primitive.newPrimitive(0)
					),
					new ModuleCall("console",
						"Client", new int[] {122,8,122,61},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Searching restaurants for "),
								new Variable(Type.STRING, "OrderId")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Client","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new While(
						"Client", new int[] {123,9,128,5},
						new Comparison("<",
							new Variable(Type.INTEGER, "i"),
							new ModuleTerm("prelude", Type.INTEGER,
								new Predicate("size", new Term[] {
									new Variable(Type.LIST, "RL")
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Prelude) intention.getModule("Client","prelude")).size(
											(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Prelude) visitor.agent().getModule("Client","prelude")).size(
											(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							)
						),
						new Block(
							"Client", new int[] {123,38,127,10},
							new Statement[] {
								new Send("Client", new int[] {124,13,124,70},
									new Performative("cfp"),
									new ModuleTerm("prelude", Type.STRING,
										new Predicate("valueAsString", new Term[] {
											new Variable(Type.LIST, "RL"),
											new Variable(Type.INTEGER, "i")
										}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((astra.lang.Prelude) intention.getModule("Client","prelude")).valueAsString(
													(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0)),
													(int) intention.evaluate(predicate.getTerm(1))
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.Prelude) visitor.agent().getModule("Client","prelude")).valueAsString(
													(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0)),
													(int) visitor.evaluate(predicate.getTerm(1))
												);
											}
										}
									),
									new Predicate("orderId", new Term[] {
										new Variable(Type.STRING, "OrderId")
									})
								),
								new ModuleCall("console",
									"Client", new int[] {125,13,125,93},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Sending CFP for "),
											Operator.newOperator('+',
												new Variable(Type.STRING, "OrderId"),
												Operator.newOperator('+',
													Primitive.newPrimitive(" for "),
													new ModuleTerm("prelude", Type.STRING,
														new Predicate("valueAsString", new Term[] {
															new Variable(Type.LIST, "RL"),
															new Variable(Type.INTEGER, "i")
														}),
														new ModuleTermAdaptor() {
															public Object invoke(Intention intention, Predicate predicate) {
																return ((astra.lang.Prelude) intention.getModule("Client","prelude")).valueAsString(
																	(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0)),
																	(int) intention.evaluate(predicate.getTerm(1))
																);
															}
															public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																return ((astra.lang.Prelude) visitor.agent().getModule("Client","prelude")).valueAsString(
																	(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0)),
																	(int) visitor.evaluate(predicate.getTerm(1))
																);
															}
														}
													)
												)
											)
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Client","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Assignment(
									new Variable(Type.INTEGER, "i"),
									"Client", new int[] {126,13,127,10},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "i"),
										Primitive.newPrimitive(1)
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
			new Predicate("nOrders", new Term[] {
				Primitive.newPrimitive(3)
			})
		);
		agent.initialize(
			new Predicate("finishedOrders", new Term[] {
				Primitive.newPrimitive(0)
			})
		);
		agent.initialize(
			new Predicate("placedOrders", new Term[] {
				Primitive.newPrimitive(0)
			})
		);
		agent.initialize(
			new Predicate("typesOfFood", new Term[] {
				Primitive.newPrimitive(10)
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(0),
				Primitive.newPrimitive("pizza")
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(1),
				Primitive.newPrimitive("hamburger")
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(2),
				Primitive.newPrimitive("burrito")
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(3),
				Primitive.newPrimitive("pastel")
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(4),
				Primitive.newPrimitive("pasta")
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(5),
				Primitive.newPrimitive("sushi")
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(6),
				Primitive.newPrimitive("seafood")
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(7),
				Primitive.newPrimitive("hotdog")
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(8),
				Primitive.newPrimitive("salad")
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(9),
				Primitive.newPrimitive("sfiha")
			})
		);
		agent.initialize(
			new Goal(
				new Predicate("init", new Term[] {})
			)
		);
		agent.initialize(
			new Goal(
				new Predicate("getLocation", new Term[] {})
			)
		);
		agent.initialize(
			new Goal(
				new Predicate("getStrategy", new Term[] {})
			)
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("console",astra.lang.Console.class,agent);
		fragment.addModule("system",astra.lang.System.class,agent);
		fragment.addModule("math",astra.lang.Math.class,agent);
		fragment.addModule("prelude",astra.lang.Prelude.class,agent);
		fragment.addModule("debug",astra.lang.Debug.class,agent);
		return fragment;
	}

	public static void main(String[] args) {
		Scheduler.setStrategy(new TestSchedulerStrategy());
		ListTerm argList = new ListTerm();
		for (String arg: args) {
			argList.add(Primitive.newPrimitive(arg));
		}

		String name = java.lang.System.getProperty("astra.name", "main");
		try {
			astra.core.Agent agent = new Client().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
