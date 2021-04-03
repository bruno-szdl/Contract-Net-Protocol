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


public class Restaurant extends ASTRAClass {
	public Restaurant() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"Restaurant", new int[] {61,9,61,39},
			new GoalEvent('+',
				new Goal(
					new Predicate("init", new Term[] {})
				)
			),
			new Predicate("typesOfFood", new Term[] {
				new Variable(Type.INTEGER, "T",false)
			}),
			new Block(
				"Restaurant", new int[] {61,38,78,9},
				new Statement[] {
					new Declaration(
						new Variable(Type.STRING, "Name"),
						"Restaurant", new int[] {62,8,78,9},
						new ModuleTerm("system", Type.STRING,
							new Predicate("name", new Term[] {}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.System) intention.getModule("Restaurant","system")).name(
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.System) visitor.agent().getModule("Restaurant","system")).name(
									);
								}
							}
						)
					),
					new BeliefUpdate('+',
						"Restaurant", new int[] {63,8,78,9},
						new Predicate("name", new Term[] {
							new Variable(Type.STRING, "Name")
						})
					),
					new ModuleCall("console",
						"Restaurant", new int[] {64,8,64,43},
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
								return ((astra.lang.Console) intention.getModule("Restaurant","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Declaration(
						new Variable(Type.INTEGER, "R"),
						"Restaurant", new int[] {65,8,78,9},
						Operator.newOperator('%',
							new ModuleTerm("math", Type.INTEGER,
								new Predicate("randomInt", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Math) intention.getModule("Restaurant","math")).randomInt(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Math) visitor.agent().getModule("Restaurant","math")).randomInt(
										);
									}
								}
							),
							Primitive.newPrimitive(10)
						)
					),
					new Query(
						"Restaurant", new int[] {66,8,66,60},
						new Predicate("food", new Term[] {
							new Variable(Type.INTEGER, "R"),
							new Variable(Type.STRING, "F",false),
							new Variable(Type.INTEGER, "minPrice",false),
							new Variable(Type.INTEGER, "maxPrice",false)
						})
					),
					new ModuleCall("df",
						"Restaurant", new int[] {67,8,67,22},
						new Predicate("register", new Term[] {
							new Variable(Type.STRING, "F")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((Df) intention.getModule("Restaurant","df")).register(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Declaration(
						new Variable(Type.INTEGER, "P"),
						"Restaurant", new int[] {68,8,78,9},
						Operator.newOperator('/',
							new Brackets(
								Operator.newOperator('*',
									Primitive.newPrimitive(10),
									Operator.newOperator('*',
										Operator.newOperator('+',
											new Variable(Type.INTEGER, "minPrice"),
											new Brackets(
												Operator.newOperator('-',
													new Variable(Type.INTEGER, "maxPrice"),
													new Variable(Type.INTEGER, "minPrice")
												)
											)
										),
										new Brackets(
											Operator.newOperator('%',
												new ModuleTerm("math", Type.INTEGER,
													new Predicate("randomInt", new Term[] {}),
													new ModuleTermAdaptor() {
														public Object invoke(Intention intention, Predicate predicate) {
															return ((astra.lang.Math) intention.getModule("Restaurant","math")).randomInt(
															);
														}
														public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((astra.lang.Math) visitor.agent().getModule("Restaurant","math")).randomInt(
															);
														}
													}
												),
												Primitive.newPrimitive(10)
											)
										)
									)
								)
							),
							Primitive.newPrimitive(10)
						)
					),
					new ModuleCall("console",
						"Restaurant", new int[] {69,9,69,61},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("I serve "),
								Operator.newOperator('+',
									new Variable(Type.STRING, "F"),
									Operator.newOperator('+',
										Primitive.newPrimitive(" for "),
										Operator.newOperator('+',
											new Variable(Type.INTEGER, "P"),
											Primitive.newPrimitive("$.")
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
								return ((astra.lang.Console) intention.getModule("Restaurant","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new BeliefUpdate('+',
						"Restaurant", new int[] {70,9,78,9},
						new Predicate("price", new Term[] {
							new Variable(Type.INTEGER, "P")
						})
					),
					new BeliefUpdate('+',
						"Restaurant", new int[] {71,9,78,9},
						new Predicate("serve", new Term[] {
							new Variable(Type.STRING, "F")
						})
					),
					new BeliefUpdate('-',
						"Restaurant", new int[] {72,8,78,9},
						new Predicate("typesOfFood", new Term[] {
							new Variable(Type.INTEGER, "T")
						})
					),
					new Declaration(
						new Variable(Type.INTEGER, "X"),
						"Restaurant", new int[] {73,8,78,9},
						Primitive.newPrimitive(0)
					),
					new While(
						"Restaurant", new int[] {74,8,78,9},
						new Comparison("<",
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "T")
						),
						new Block(
							"Restaurant", new int[] {74,20,77,13},
							new Statement[] {
								new BeliefUpdate('-',
									"Restaurant", new int[] {75,12,77,13},
									new Predicate("food", new Term[] {
										new Variable(Type.INTEGER, "X"),
										new Variable(Type.STRING, "S",false),
										new Variable(Type.INTEGER, "I",false),
										new Variable(Type.INTEGER, "J",false)
									})
								),
								new Assignment(
									new Variable(Type.INTEGER, "X"),
									"Restaurant", new int[] {76,12,77,13},
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
			"Restaurant", new int[] {80,9,80,25},
			new GoalEvent('+',
				new Goal(
					new Predicate("getLocation", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Restaurant", new int[] {80,24,88,9},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "X"),
						"Restaurant", new int[] {81,8,88,9},
						Operator.newOperator('%',
							new ModuleTerm("math", Type.INTEGER,
								new Predicate("randomInt", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Math) intention.getModule("Restaurant","math")).randomInt(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Math) visitor.agent().getModule("Restaurant","math")).randomInt(
										);
									}
								}
							),
							Primitive.newPrimitive(100)
						)
					),
					new Declaration(
						new Variable(Type.INTEGER, "Y"),
						"Restaurant", new int[] {82,8,88,9},
						Operator.newOperator('%',
							new ModuleTerm("math", Type.INTEGER,
								new Predicate("randomInt", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Math) intention.getModule("Restaurant","math")).randomInt(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Math) visitor.agent().getModule("Restaurant","math")).randomInt(
										);
									}
								}
							),
							Primitive.newPrimitive(100)
						)
					),
					new Declaration(
						new Variable(Type.INTEGER, "R"),
						"Restaurant", new int[] {83,8,88,9},
						Operator.newOperator('%',
							new ModuleTerm("math", Type.INTEGER,
								new Predicate("randomInt", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Math) intention.getModule("Restaurant","math")).randomInt(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Math) visitor.agent().getModule("Restaurant","math")).randomInt(
										);
									}
								}
							),
							Primitive.newPrimitive(100)
						)
					),
					new Declaration(
						new Variable(Type.INTEGER, "Radius"),
						"Restaurant", new int[] {84,8,88,9},
						Operator.newOperator('*',
							Operator.newOperator('-',
								Primitive.newPrimitive(80),
								Primitive.newPrimitive(60)
							),
							new Variable(Type.INTEGER, "R")
						)
					),
					new BeliefUpdate('+',
						"Restaurant", new int[] {85,8,88,9},
						new Predicate("location", new Term[] {
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "Y")
						})
					),
					new BeliefUpdate('+',
						"Restaurant", new int[] {86,8,88,9},
						new Predicate("radius", new Term[] {
							new Variable(Type.INTEGER, "Radius")
						})
					),
					new ModuleCall("console",
						"Restaurant", new int[] {87,8,87,99},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("I am located in ("),
								Operator.newOperator('+',
									new Variable(Type.INTEGER, "X"),
									Operator.newOperator('+',
										Primitive.newPrimitive(", "),
										Operator.newOperator('+',
											new Variable(Type.INTEGER, "Y"),
											Operator.newOperator('+',
												Primitive.newPrimitive("). My delivery radius is "),
												Operator.newOperator('+',
													new Variable(Type.INTEGER, "Radius"),
													Primitive.newPrimitive("m.")
												)
											)
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
								return ((astra.lang.Console) intention.getModule("Restaurant","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Restaurant", new int[] {90,9,90,21},
			new GoalEvent('+',
				new Goal(
					new Predicate("getRate", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Restaurant", new int[] {90,20,93,9},
				new Statement[] {
					new Declaration(
						new Variable(Type.DOUBLE, "S"),
						"Restaurant", new int[] {91,8,93,9},
						Primitive.newPrimitive(5.0)
					),
					new BeliefUpdate('+',
						"Restaurant", new int[] {92,8,93,9},
						new Predicate("rate", new Term[] {
							new Variable(Type.DOUBLE, "S")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Restaurant", new int[] {95,9,95,78},
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
				"Restaurant", new int[] {95,77,110,9},
				new Statement[] {
					new Query(
						"Restaurant", new int[] {96,8,96,39},
						new Predicate("location", new Term[] {
							new Variable(Type.INTEGER, "XR",false),
							new Variable(Type.INTEGER, "YR",false)
						})
					),
					new Query(
						"Restaurant", new int[] {97,8,97,29},
						new Predicate("radius", new Term[] {
							new Variable(Type.INTEGER, "Rd",false)
						})
					),
					new Query(
						"Restaurant", new int[] {98,8,98,27},
						new Predicate("price", new Term[] {
							new Variable(Type.INTEGER, "P",false)
						})
					),
					new Query(
						"Restaurant", new int[] {99,8,99,29},
						new Predicate("rate", new Term[] {
							new Variable(Type.DOUBLE, "S",false)
						})
					),
					new Declaration(
						new Variable(Type.INTEGER, "distance"),
						"Restaurant", new int[] {100,8,110,9},
						Operator.newOperator('+',
							new ModuleTerm("math", Type.INTEGER,
								new Predicate("abs", new Term[] {
									Operator.newOperator('-',
										new Variable(Type.INTEGER, "XR"),
										new Variable(Type.INTEGER, "X")
									)
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Math) intention.getModule("Restaurant","math")).abs(
											(int) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Math) visitor.agent().getModule("Restaurant","math")).abs(
											(int) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							),
							new ModuleTerm("math", Type.INTEGER,
								new Predicate("abs", new Term[] {
									Operator.newOperator('-',
										new Variable(Type.INTEGER, "YR"),
										new Variable(Type.INTEGER, "Y")
									)
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Math) intention.getModule("Restaurant","math")).abs(
											(int) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Math) visitor.agent().getModule("Restaurant","math")).abs(
											(int) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							)
						)
					),
					new If(
						"Restaurant", new int[] {101,8,110,9},
						new Comparison("<",
							new Variable(Type.INTEGER, "distance"),
							new Variable(Type.INTEGER, "Rd")
						),
						new Block(
							"Restaurant", new int[] {101,26,106,9},
							new Statement[] {
								new Declaration(
									new Variable(Type.INTEGER, "Total"),
									"Restaurant", new int[] {102,12,106,9},
									Operator.newOperator('/',
										new Variable(Type.INTEGER, "distance"),
										Operator.newOperator('+',
											Primitive.newPrimitive(2),
											new Variable(Type.INTEGER, "P")
										)
									)
								),
								new Send("Restaurant", new int[] {105,12,105,65},
									new Performative("propose"),
									new Variable(Type.STRING, "sender"),
									new Predicate("sendPropose", new Term[] {
										new Variable(Type.STRING, "OrderId"),
										new Variable(Type.INTEGER, "Total"),
										new Variable(Type.DOUBLE, "S")
									})
								)
							}
						),
						new Block(
							"Restaurant", new int[] {106,14,110,9},
							new Statement[] {
								new Send("Restaurant", new int[] {108,12,108,53},
									new Performative("refuse"),
									new Variable(Type.STRING, "sender"),
									new Predicate("sendRefuse", new Term[] {
										new Variable(Type.STRING, "OrderId")
									})
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Restaurant", new int[] {112,9,112,92},
			new MessageEvent(
				new Performative("reject-proposal"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("offer_denied", new Term[] {
					new Variable(Type.STRING, "OrderId",false),
					new Variable(Type.INTEGER, "Total",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Restaurant", new int[] {112,91,114,5},
				new Statement[] {
					new Send("Restaurant", new int[] {113,8,113,40},
						new Performative("inform"),
						new Variable(Type.STRING, "sender"),
						new Predicate("tell", new Term[] {
							Primitive.newPrimitive("ok")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Restaurant", new int[] {116,9,116,108},
			new MessageEvent(
				new Performative("accept-proposal"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("offer_accepted", new Term[] {
					new Variable(Type.STRING, "OrderId",false),
					new Variable(Type.INTEGER, "Total",false),
					new Variable(Type.INTEGER, "X",false),
					new Variable(Type.INTEGER, "Y",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Restaurant", new int[] {116,107,122,5},
				new Statement[] {
					new BeliefUpdate('+',
						"Restaurant", new int[] {117,8,122,5},
						new Predicate("needToDeliver", new Term[] {
							new Variable(Type.STRING, "OrderId"),
							new Variable(Type.STRING, "sender"),
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "Y")
						})
					),
					new Query(
						"Restaurant", new int[] {119,8,119,27},
						new Predicate("sells", new Term[] {
							new Variable(Type.INTEGER, "S",false)
						})
					),
					new SpecialBeliefUpdate(
						"Restaurant", new int[] {120,8,122,5},
						new Predicate("sells", new Term[] {
							Operator.newOperator('+',
								new Variable(Type.INTEGER, "S"),
								Primitive.newPrimitive(1)
							)
						})
					),
					new Send("Restaurant", new int[] {121,8,121,48},
						new Performative("inform"),
						new Variable(Type.STRING, "sender"),
						new Predicate("preparing", new Term[] {
							new Variable(Type.STRING, "OrderId")
						})
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("sells", new Term[] {
				Primitive.newPrimitive(0)
			})
		);
		agent.initialize(
			new Predicate("thinking", new Term[] {
				Primitive.newPrimitive(false)
			})
		);
		agent.initialize(
			new Predicate("searching", new Term[] {
				Primitive.newPrimitive(false)
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
				Primitive.newPrimitive("pizza"),
				Primitive.newPrimitive(20),
				Primitive.newPrimitive(100)
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(1),
				Primitive.newPrimitive("hamburger"),
				Primitive.newPrimitive(10),
				Primitive.newPrimitive(50)
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(2),
				Primitive.newPrimitive("burrito"),
				Primitive.newPrimitive(18),
				Primitive.newPrimitive(50)
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(3),
				Primitive.newPrimitive("pastel"),
				Primitive.newPrimitive(5),
				Primitive.newPrimitive(35)
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(4),
				Primitive.newPrimitive("pasta"),
				Primitive.newPrimitive(20),
				Primitive.newPrimitive(140)
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(5),
				Primitive.newPrimitive("sushi"),
				Primitive.newPrimitive(70),
				Primitive.newPrimitive(200)
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(6),
				Primitive.newPrimitive("seafood"),
				Primitive.newPrimitive(20),
				Primitive.newPrimitive(120)
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(7),
				Primitive.newPrimitive("hotdog"),
				Primitive.newPrimitive(8),
				Primitive.newPrimitive(30)
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(8),
				Primitive.newPrimitive("salad"),
				Primitive.newPrimitive(15),
				Primitive.newPrimitive(40)
			})
		);
		agent.initialize(
			new Predicate("food", new Term[] {
				Primitive.newPrimitive(9),
				Primitive.newPrimitive("sfiha"),
				Primitive.newPrimitive(20),
				Primitive.newPrimitive(40)
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
				new Predicate("getRate", new Term[] {})
			)
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("func",astra.lang.Functions.class,agent);
		fragment.addModule("console",astra.lang.Console.class,agent);
		fragment.addModule("system",astra.lang.System.class,agent);
		fragment.addModule("math",astra.lang.Math.class,agent);
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
			astra.core.Agent agent = new Restaurant().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
