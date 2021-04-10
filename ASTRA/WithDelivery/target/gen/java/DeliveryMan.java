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
			"DeliveryMan", new int[] {35,9,35,18},
			new GoalEvent('+',
				new Goal(
					new Predicate("init", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"DeliveryMan", new int[] {35,17,38,9},
				new Statement[] {
					new ModuleCall("console",
						"DeliveryMan", new int[] {36,8,36,50},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Hi, I am a delivery man")
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
					new ModuleCall("df",
						"DeliveryMan", new int[] {37,8,37,34},
						new Predicate("register", new Term[] {
							Primitive.newPrimitive("deliveryman")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((Df) intention.getModule("DeliveryMan","df")).register(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"DeliveryMan", new int[] {40,9,40,25},
			new GoalEvent('+',
				new Goal(
					new Predicate("getLocation", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"DeliveryMan", new int[] {40,24,45,9},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "X"),
						"DeliveryMan", new int[] {41,8,45,9},
						Operator.newOperator('%',
							new ModuleTerm("math", Type.INTEGER,
								new Predicate("randomInt", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Math) intention.getModule("DeliveryMan","math")).randomInt(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Math) visitor.agent().getModule("DeliveryMan","math")).randomInt(
										);
									}
								}
							),
							Primitive.newPrimitive(100)
						)
					),
					new Declaration(
						new Variable(Type.INTEGER, "Y"),
						"DeliveryMan", new int[] {42,8,45,9},
						Operator.newOperator('%',
							new ModuleTerm("math", Type.INTEGER,
								new Predicate("randomInt", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Math) intention.getModule("DeliveryMan","math")).randomInt(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Math) visitor.agent().getModule("DeliveryMan","math")).randomInt(
										);
									}
								}
							),
							Primitive.newPrimitive(100)
						)
					),
					new BeliefUpdate('+',
						"DeliveryMan", new int[] {43,8,45,9},
						new Predicate("location", new Term[] {
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "Y")
						})
					),
					new ModuleCall("console",
						"DeliveryMan", new int[] {44,8,44,64},
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
								return ((astra.lang.Console) intention.getModule("DeliveryMan","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"DeliveryMan", new int[] {47,9,47,78},
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
				"DeliveryMan", new int[] {47,77,60,9},
				new Statement[] {
					new Query(
						"DeliveryMan", new int[] {49,8,49,33},
						new Predicate("working", new Term[] {
							new Variable(Type.BOOLEAN, "w",false)
						})
					),
					new If(
						"DeliveryMan", new int[] {50,8,60,9},
						new Comparison("==",
							new Variable(Type.BOOLEAN, "w"),
							Primitive.newPrimitive(true)
						),
						new Block(
							"DeliveryMan", new int[] {50,22,54,9},
							new Statement[] {
								new ModuleCall("system",
									"DeliveryMan", new int[] {51,12,51,44},
									new Predicate("sleep", new Term[] {
										Operator.newOperator('%',
											new ModuleTerm("math", Type.INTEGER,
												new Predicate("randomInt", new Term[] {}),
												new ModuleTermAdaptor() {
													public Object invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Math) intention.getModule("DeliveryMan","math")).randomInt(
														);
													}
													public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
														return ((astra.lang.Math) visitor.agent().getModule("DeliveryMan","math")).randomInt(
														);
													}
												}
											),
											Primitive.newPrimitive(10)
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return false;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.System) intention.getModule("DeliveryMan","system")).sleep(
												(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Send("DeliveryMan", new int[] {52,12,52,61},
									new Performative("refuse"),
									new Variable(Type.STRING, "sender"),
									new Predicate("sendRefuseDelivery", new Term[] {
										new Variable(Type.STRING, "OrderId")
									})
								)
							}
						),
						new Block(
							"DeliveryMan", new int[] {54,14,60,9},
							new Statement[] {
								new Query(
									"DeliveryMan", new int[] {55,12,55,43},
									new Predicate("location", new Term[] {
										new Variable(Type.INTEGER, "XD",false),
										new Variable(Type.INTEGER, "YD",false)
									})
								),
								new Declaration(
									new Variable(Type.INTEGER, "distance"),
									"DeliveryMan", new int[] {56,12,59,75},
									Operator.newOperator('+',
										new ModuleTerm("math", Type.INTEGER,
											new Predicate("abs", new Term[] {
												Operator.newOperator('-',
													new Variable(Type.INTEGER, "XD"),
													new Variable(Type.INTEGER, "X")
												)
											}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((astra.lang.Math) intention.getModule("DeliveryMan","math")).abs(
														(int) intention.evaluate(predicate.getTerm(0))
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.Math) visitor.agent().getModule("DeliveryMan","math")).abs(
														(int) visitor.evaluate(predicate.getTerm(0))
													);
												}
											}
										),
										new ModuleTerm("math", Type.INTEGER,
											new Predicate("abs", new Term[] {
												Operator.newOperator('-',
													new Variable(Type.INTEGER, "YD"),
													new Variable(Type.INTEGER, "Y")
												)
											}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((astra.lang.Math) intention.getModule("DeliveryMan","math")).abs(
														(int) intention.evaluate(predicate.getTerm(0))
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.Math) visitor.agent().getModule("DeliveryMan","math")).abs(
														(int) visitor.evaluate(predicate.getTerm(0))
													);
												}
											}
										)
									)
								),
								new ModuleCall("system",
									"DeliveryMan", new int[] {58,12,58,44},
									new Predicate("sleep", new Term[] {
										Operator.newOperator('%',
											new ModuleTerm("math", Type.INTEGER,
												new Predicate("randomInt", new Term[] {}),
												new ModuleTermAdaptor() {
													public Object invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Math) intention.getModule("DeliveryMan","math")).randomInt(
														);
													}
													public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
														return ((astra.lang.Math) visitor.agent().getModule("DeliveryMan","math")).randomInt(
														);
													}
												}
											),
											Primitive.newPrimitive(10)
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return false;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.System) intention.getModule("DeliveryMan","system")).sleep(
												(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Send("DeliveryMan", new int[] {59,12,59,73},
									new Performative("propose"),
									new Variable(Type.STRING, "sender"),
									new Predicate("sendProposeDelivery", new Term[] {
										new Variable(Type.STRING, "OrderId"),
										new Variable(Type.INTEGER, "distance")
									})
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"DeliveryMan", new int[] {62,9,62,103},
			new MessageEvent(
				new Performative("reject-proposal"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("offer_deniedDelivery", new Term[] {
					new Variable(Type.STRING, "OrderId",false),
					new Variable(Type.INTEGER, "distance",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"DeliveryMan", new int[] {62,102,64,5},
				new Statement[] {
					new Send("DeliveryMan", new int[] {63,8,63,40},
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
			"DeliveryMan", new int[] {66,9,66,105},
			new MessageEvent(
				new Performative("accept-proposal"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("offer_acceptedDelivery", new Term[] {
					new Variable(Type.STRING, "OrderId",false),
					new Variable(Type.INTEGER, "distance",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"DeliveryMan", new int[] {66,104,88,5},
				new Statement[] {
					new Query(
						"DeliveryMan", new int[] {68,8,68,33},
						new Predicate("working", new Term[] {
							new Variable(Type.BOOLEAN, "w",false)
						})
					),
					new If(
						"DeliveryMan", new int[] {69,8,88,5},
						new Comparison("==",
							new Variable(Type.BOOLEAN, "w"),
							Primitive.newPrimitive(true)
						),
						new Block(
							"DeliveryMan", new int[] {69,22,72,9},
							new Statement[] {
								new Send("DeliveryMan", new int[] {71,12,71,63},
									new Performative("failure"),
									new Variable(Type.STRING, "sender"),
									new Predicate("sendFailureDelivery", new Term[] {
										new Variable(Type.STRING, "OrderId")
									})
								)
							}
						),
						new Block(
							"DeliveryMan", new int[] {72,14,88,5},
							new Statement[] {
								new SpecialBeliefUpdate(
									"DeliveryMan", new int[] {73,12,87,9},
									new Predicate("working", new Term[] {
										Primitive.newPrimitive(true)
									})
								),
								new ModuleCall("system",
									"DeliveryMan", new int[] {74,12,74,34},
									new Predicate("sleep", new Term[] {
										new Variable(Type.INTEGER, "distance")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return false;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.System) intention.getModule("DeliveryMan","system")).sleep(
												(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Query(
									"DeliveryMan", new int[] {75,12,75,36},
									new Predicate("deliveries", new Term[] {
										new Variable(Type.INTEGER, "S",false)
									})
								),
								new SpecialBeliefUpdate(
									"DeliveryMan", new int[] {76,12,87,9},
									new Predicate("deliveries", new Term[] {
										Operator.newOperator('+',
											new Variable(Type.INTEGER, "S"),
											Primitive.newPrimitive(1)
										)
									})
								),
								new ModuleCall("console",
									"DeliveryMan", new int[] {77,12,77,31},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											new Variable(Type.INTEGER, "S"),
											Primitive.newPrimitive(1)
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("DeliveryMan","console")).println(
												(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Send("DeliveryMan", new int[] {78,12,78,53},
									new Performative("inform"),
									new Variable(Type.STRING, "sender"),
									new Predicate("delivering", new Term[] {
										new Variable(Type.STRING, "OrderId")
									})
								),
								new Declaration(
									new Variable(Type.LIST, "clientNameList"),
									"DeliveryMan", new int[] {81,12,87,9},
									new ModuleTerm("strings", Type.LIST,
										new Predicate("split", new Term[] {
											new Variable(Type.STRING, "OrderId"),
											Primitive.newPrimitive(";")
										}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((astra.lang.Strings) intention.getModule("DeliveryMan","strings")).split(
													(java.lang.String) intention.evaluate(predicate.getTerm(0)),
													(java.lang.String) intention.evaluate(predicate.getTerm(1))
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.Strings) visitor.agent().getModule("DeliveryMan","strings")).split(
													(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
													(java.lang.String) visitor.evaluate(predicate.getTerm(1))
												);
											}
										}
									)
								),
								new Declaration(
									new Variable(Type.STRING, "clientName"),
									"DeliveryMan", new int[] {82,12,87,9},
									new ModuleTerm("prelude", Type.STRING,
										new Predicate("headAsString", new Term[] {
											new Variable(Type.LIST, "clientNameList")
										}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((astra.lang.Prelude) intention.getModule("DeliveryMan","prelude")).headAsString(
													(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.Prelude) visitor.agent().getModule("DeliveryMan","prelude")).headAsString(
													(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0))
												);
											}
										}
									)
								),
								new Send("DeliveryMan", new int[] {83,12,83,56},
									new Performative("inform"),
									new Variable(Type.STRING, "clientName"),
									new Predicate("delivered", new Term[] {
										new Variable(Type.STRING, "OrderId")
									})
								),
								new ModuleCall("console",
									"DeliveryMan", new int[] {84,12,84,75},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Informimg client about the deliver "),
											new Variable(Type.STRING, "OrderId")
										)
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
								new SpecialBeliefUpdate(
									"DeliveryMan", new int[] {85,12,87,9},
									new Predicate("working", new Term[] {
										Primitive.newPrimitive(false)
									})
								),
								new ModuleCall("debug",
									"DeliveryMan", new int[] {86,12,86,31},
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
			new Predicate("working", new Term[] {
				Primitive.newPrimitive(false)
			})
		);
		agent.initialize(
			new Predicate("money", new Term[] {
				Primitive.newPrimitive(0)
			})
		);
		agent.initialize(
			new Predicate("deliveries", new Term[] {
				Primitive.newPrimitive(0)
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
		fragment.addModule("system",astra.lang.System.class,agent);
		fragment.addModule("console",astra.lang.Console.class,agent);
		fragment.addModule("debug",astra.lang.Debug.class,agent);
		fragment.addModule("df",Df.class,agent);
		fragment.addModule("strings",astra.lang.Strings.class,agent);
		fragment.addModule("math",astra.lang.Math.class,agent);
		fragment.addModule("prelude",astra.lang.Prelude.class,agent);
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
