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
			"Restaurant", new int[] {64,9,64,39},
			new GoalEvent('+',
				new Goal(
					new Predicate("init", new Term[] {})
				)
			),
			new Predicate("typesOfFood", new Term[] {
				new Variable(Type.INTEGER, "T",false)
			}),
			new Block(
				"Restaurant", new int[] {64,38,78,9},
				new Statement[] {
					new Declaration(
						new Variable(Type.STRING, "Name"),
						"Restaurant", new int[] {65,8,78,9},
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
						"Restaurant", new int[] {66,8,78,9},
						new Predicate("name", new Term[] {
							new Variable(Type.STRING, "Name")
						})
					),
					new ModuleCall("console",
						"Restaurant", new int[] {67,8,67,43},
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
						"Restaurant", new int[] {68,8,78,9},
						Operator.newOperator('/',
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
							Primitive.newPrimitive(225000000)
						)
					),
					new Subgoal(
						"Restaurant", new int[] {70,8,78,9},
						new Goal(
							new Predicate("chooseFood", new Term[] {
								new Variable(Type.INTEGER, "R")
							})
						)
					),
					new ModuleCall("system",
						"Restaurant", new int[] {71,8,71,24},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(100)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Restaurant","system")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
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
			"Restaurant", new int[] {80,10,81,56},
			new GoalEvent('+',
				new Goal(
					new Predicate("chooseFood", new Term[] {
						new Variable(Type.INTEGER, "R",false)
					})
				)
			),
			new Predicate("food", new Term[] {
				new Variable(Type.INTEGER, "R"),
				new Variable(Type.STRING, "F",false),
				new Variable(Type.INTEGER, "minPrice",false),
				new Variable(Type.INTEGER, "maxPrice",false)
			}),
			new Block(
				"Restaurant", new int[] {81,55,87,14},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "Rand"),
						"Restaurant", new int[] {82,13,87,14},
						Operator.newOperator('/',
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
							Primitive.newPrimitive(225000000)
						)
					),
					new Declaration(
						new Variable(Type.INTEGER, "P"),
						"Restaurant", new int[] {83,13,87,14},
						Operator.newOperator('/',
							new Brackets(
								Operator.newOperator('*',
									Primitive.newPrimitive(9),
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
										new Variable(Type.INTEGER, "Rand")
									)
								)
							),
							Primitive.newPrimitive(90)
						)
					),
					new ModuleCall("console",
						"Restaurant", new int[] {84,13,84,65},
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
						"Restaurant", new int[] {85,13,87,14},
						new Predicate("price", new Term[] {
							new Variable(Type.INTEGER, "P")
						})
					),
					new BeliefUpdate('+',
						"Restaurant", new int[] {86,13,87,14},
						new Predicate("serve", new Term[] {
							new Variable(Type.STRING, "F")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Restaurant", new int[] {89,9,89,25},
			new GoalEvent('+',
				new Goal(
					new Predicate("getLocation", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Restaurant", new int[] {89,24,94,9},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "X"),
						"Restaurant", new int[] {90,8,94,9},
						Operator.newOperator('/',
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
							Primitive.newPrimitive(100000000)
						)
					),
					new Declaration(
						new Variable(Type.INTEGER, "Y"),
						"Restaurant", new int[] {91,8,94,9},
						Operator.newOperator('/',
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
							Primitive.newPrimitive(100000000)
						)
					),
					new BeliefUpdate('+',
						"Restaurant", new int[] {92,8,94,9},
						new Predicate("location", new Term[] {
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "Y")
						})
					),
					new ModuleCall("console",
						"Restaurant", new int[] {93,8,93,64},
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
								return ((astra.lang.Console) intention.getModule("Restaurant","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("stars", new Term[] {
				Primitive.newPrimitive(5)
			})
		);
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
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("console",astra.lang.Console.class,agent);
		fragment.addModule("system",astra.lang.System.class,agent);
		fragment.addModule("math",astra.lang.Math.class,agent);
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
