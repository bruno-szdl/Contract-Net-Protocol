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
			"Client", new int[] {65,9,67,23},
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
				"Client", new int[] {67,22,90,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.STRING, "Name"),
						"Client", new int[] {68,8,90,5},
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
						"Client", new int[] {69,8,90,5},
						new Predicate("name", new Term[] {
							new Variable(Type.STRING, "Name")
						})
					),
					new ModuleCall("console",
						"Client", new int[] {70,8,70,43},
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
					new Declaration(
						new Variable(Type.INTEGER, "X"),
						"Client", new int[] {71,8,90,5},
						Primitive.newPrimitive(0)
					),
					new While(
						"Client", new int[] {72,8,90,5},
						new Comparison("<",
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "N")
						),
						new Block(
							"Client", new int[] {72,20,80,9},
							new Statement[] {
								new Assignment(
									new Variable(Type.INTEGER, "X"),
									"Client", new int[] {73,12,80,9},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "X"),
										Primitive.newPrimitive(1)
									)
								),
								new Declaration(
									new Variable(Type.INTEGER, "R"),
									"Client", new int[] {74,12,80,9},
									Operator.newOperator('%',
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
										Primitive.newPrimitive(10)
									)
								),
								new Query(
									"Client", new int[] {75,12,75,36},
									new Predicate("food", new Term[] {
										new Variable(Type.INTEGER, "R"),
										new Variable(Type.STRING, "F",false)
									})
								),
								new Declaration(
									new Variable(Type.STRING, "OrderId"),
									"Client", new int[] {76,12,80,9},
									Operator.newOperator('+',
										new Variable(Type.STRING, "Name"),
										Operator.newOperator('+',
											Primitive.newPrimitive(";Order_"),
											Operator.newOperator('+',
												new Variable(Type.INTEGER, "X"),
												Operator.newOperator('+',
													Primitive.newPrimitive(";"),
													new Variable(Type.STRING, "F")
												)
											)
										)
									)
								),
								new BeliefUpdate('+',
									"Client", new int[] {77,12,80,9},
									new Predicate("orderId", new Term[] {
										new Variable(Type.STRING, "OrderId")
									})
								),
								new BeliefUpdate('+',
									"Client", new int[] {78,12,80,9},
									new Predicate("wantToOrder", new Term[] {
										new Variable(Type.STRING, "OrderId"),
										new Variable(Type.STRING, "F")
									})
								),
								new ModuleCall("console",
									"Client", new int[] {79,12,79,54},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("I want to eat some "),
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
								)
							}
						)
					),
					new ModuleCall("console",
						"Client", new int[] {81,8,81,56},
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
						"Client", new int[] {82,8,90,5},
						new Predicate("typesOfFood", new Term[] {
							new Variable(Type.INTEGER, "T")
						})
					),
					new While(
						"Client", new int[] {83,8,90,5},
						new Predicate("food", new Term[] {
							new Variable(Type.INTEGER, "Y",false),
							new Variable(Type.STRING, "S",false)
						}),
						new Block(
							"Client", new int[] {83,36,85,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Client", new int[] {84,12,85,9},
									new Predicate("food", new Term[] {
										new Variable(Type.INTEGER, "Y"),
										new Variable(Type.STRING, "S")
									})
								)
							}
						)
					),
					new Subgoal(
						"Client", new int[] {86,8,90,5},
						new Goal(
							new Predicate("getLocation", new Term[] {})
						)
					),
					new Subgoal(
						"Client", new int[] {87,8,90,5},
						new Goal(
							new Predicate("getStrategy", new Term[] {})
						)
					),
					new Subgoal(
						"Client", new int[] {89,8,90,5},
						new Goal(
							new Predicate("placeOrders", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Client", new int[] {91,9,91,25},
			new GoalEvent('+',
				new Goal(
					new Predicate("getLocation", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Client", new int[] {91,24,96,9},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "X"),
						"Client", new int[] {92,8,96,9},
						Operator.newOperator('%',
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
							Primitive.newPrimitive(100)
						)
					),
					new Declaration(
						new Variable(Type.INTEGER, "Y"),
						"Client", new int[] {93,8,96,9},
						Operator.newOperator('%',
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
							Primitive.newPrimitive(100)
						)
					),
					new BeliefUpdate('+',
						"Client", new int[] {94,8,96,9},
						new Predicate("location", new Term[] {
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "Y")
						})
					),
					new ModuleCall("console",
						"Client", new int[] {95,8,95,64},
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
			"Client", new int[] {98,9,98,25},
			new GoalEvent('+',
				new Goal(
					new Predicate("getStrategy", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Client", new int[] {98,24,102,9},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "S"),
						"Client", new int[] {99,8,102,9},
						Operator.newOperator('%',
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
							Primitive.newPrimitive(2)
						)
					),
					new BeliefUpdate('+',
						"Client", new int[] {100,8,102,9},
						new Predicate("strategy", new Term[] {
							new Variable(Type.INTEGER, "S")
						})
					),
					new ModuleCall("console",
						"Client", new int[] {101,8,101,38},
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
			"Client", new int[] {104,9,105,33},
			new GoalEvent('+',
				new Goal(
					new Predicate("placeOrders", new Term[] {})
				)
			),
			new Predicate("location", new Term[] {
				new Variable(Type.INTEGER, "X",false),
				new Variable(Type.INTEGER, "Y",false)
			}),
			new Block(
				"Client", new int[] {105,32,112,9},
				new Statement[] {
					new While(
						"Client", new int[] {106,12,112,9},
						new Predicate("wantToOrder", new Term[] {
							new Variable(Type.STRING, "OrderId",false),
							new Variable(Type.STRING, "F",false)
						}),
						new Block(
							"Client", new int[] {106,56,111,13},
							new Statement[] {
								new BeliefUpdate('-',
									"Client", new int[] {107,16,111,13},
									new Predicate("wantToOrder", new Term[] {
										new Variable(Type.STRING, "OrderId"),
										new Variable(Type.STRING, "F")
									})
								),
								new ModuleCall("system",
									"Client", new int[] {109,16,109,49},
									new Predicate("sleep", new Term[] {
										Operator.newOperator('%',
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
											Primitive.newPrimitive(100)
										)
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
								new SpawnGoal(
									"Client", new int[] {110,16,111,13},
									new Goal(
										new Predicate("cnp", new Term[] {
											new Variable(Type.STRING, "OrderId"),
											new Variable(Type.STRING, "F"),
											new Variable(Type.INTEGER, "X"),
											new Variable(Type.INTEGER, "Y")
										})
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Client", new int[] {114,9,114,56},
			new GoalEvent('+',
				new Goal(
					new Predicate("cnp", new Term[] {
						new Variable(Type.STRING, "OrderId",false),
						new Variable(Type.STRING, "F",false),
						new Variable(Type.INTEGER, "X",false),
						new Variable(Type.INTEGER, "Y",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Client", new int[] {114,55,118,9},
				new Statement[] {
					new ModuleCall("system",
						"Client", new int[] {115,12,115,45},
						new Predicate("sleep", new Term[] {
							Operator.newOperator('%',
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
								Primitive.newPrimitive(100)
							)
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
					new Subgoal(
						"Client", new int[] {117,12,118,9},
						new Goal(
							new Predicate("callForRestaurants", new Term[] {
								new Variable(Type.STRING, "OrderId"),
								new Variable(Type.STRING, "F"),
								new Variable(Type.INTEGER, "X"),
								new Variable(Type.INTEGER, "Y")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Client", new int[] {120,9,120,71},
			new GoalEvent('+',
				new Goal(
					new Predicate("callForRestaurants", new Term[] {
						new Variable(Type.STRING, "OrderId",false),
						new Variable(Type.STRING, "F",false),
						new Variable(Type.INTEGER, "X",false),
						new Variable(Type.INTEGER, "Y",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Client", new int[] {120,70,132,9},
				new Statement[] {
					new ModuleCall("df",
						"Client", new int[] {122,12,122,33},
						new Predicate("search", new Term[] {
							new Variable(Type.STRING, "F"),
							new Variable(Type.LIST, "LR",false)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((Df) intention.getModule("Client","df")).search(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(ActionParam<astra.term.ListTerm>) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new BeliefUpdate('+',
						"Client", new int[] {123,12,132,9},
						new Predicate("restaurant_count", new Term[] {
							new Variable(Type.STRING, "OrderId"),
							new Count(
								new Variable(Type.LIST, "LR")
							)
						})
					),
					new If(
						"Client", new int[] {125,12,132,9},
						new Comparison("==",
							new Variable(Type.LIST, "LR"),
							new ListTerm(new Term[] {
								Primitive.newPrimitive("register")
							})
						),
						new Block(
							"Client", new int[] {125,35,129,13},
							new Statement[] {
								new ModuleCall("system",
									"Client", new int[] {127,16,127,49},
									new Predicate("sleep", new Term[] {
										Operator.newOperator('%',
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
											Primitive.newPrimitive(100)
										)
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
								new BeliefUpdate('+',
									"Client", new int[] {128,16,129,13},
									new Predicate("notFound", new Term[] {
										new Variable(Type.STRING, "OrderId")
									})
								)
							}
						),
						new Block(
							"Client", new int[] {129,18,132,9},
							new Statement[] {
								new Send("Client", new int[] {130,12,130,49},
									new Performative("cfp"),
									new Variable(Type.LIST, "LR"),
									new Predicate("sendCFP", new Term[] {
										new Variable(Type.STRING, "OrderId"),
										new Variable(Type.INTEGER, "X"),
										new Variable(Type.INTEGER, "Y")
									})
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Client", new int[] {134,9,134,93},
			new MessageEvent(
				new Performative("propose"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("sendPropose", new Term[] {
					new Variable(Type.STRING, "OrderId",false),
					new Variable(Type.INTEGER, "Total",false),
					new Variable(Type.DOUBLE, "S",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Client", new int[] {134,92,138,5},
				new Statement[] {
					new BeliefUpdate('+',
						"Client", new int[] {135,8,138,5},
						new Predicate("proposal", new Term[] {
							new Variable(Type.STRING, "OrderId"),
							new Variable(Type.STRING, "sender"),
							new Variable(Type.INTEGER, "Total"),
							new Variable(Type.DOUBLE, "S")
						})
					),
					new Subgoal(
						"Client", new int[] {137,8,138,5},
						new Goal(
							new Predicate("call_done", new Term[] {
								new Variable(Type.STRING, "OrderId")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Client", new int[] {140,9,140,70},
			new MessageEvent(
				new Performative("refuse"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("sendRefuse", new Term[] {
					new Variable(Type.STRING, "OrderId",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Client", new int[] {140,69,144,5},
				new Statement[] {
					new BeliefUpdate('+',
						"Client", new int[] {141,8,144,5},
						new Predicate("refusal", new Term[] {
							new Variable(Type.STRING, "OrderId"),
							new Variable(Type.STRING, "sender")
						})
					),
					new Subgoal(
						"Client", new int[] {143,8,144,5},
						new Goal(
							new Predicate("call_done", new Term[] {
								new Variable(Type.STRING, "OrderId")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Client", new int[] {146,9,147,156},
			new GoalEvent('+',
				new Goal(
					new Predicate("call_done", new Term[] {
						new Variable(Type.STRING, "OrderId",false)
					})
				)
			),
			new Predicate("restaurant_count", new Term[] {
				new Variable(Type.STRING, "OrderId"),
				Operator.newOperator('+',
					new ModuleTerm("check", Type.INTEGER,
						new Predicate("count", new Term[] {
							new Funct("proposal", new Term[] {
								new Variable(Type.STRING, "OrderId"),
								new Variable(Type.STRING, "sender",false),
								new Variable(Type.INTEGER, "Total",false),
								new Variable(Type.DOUBLE, "S",false)
							})
						}),
						new ModuleTermAdaptor() {
							public Object invoke(Intention intention, Predicate predicate) {
								return ((Check) intention.getModule("Client","check")).count(
									(astra.term.Funct) intention.evaluate(predicate.getTerm(0))
								);
							}
							public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
								return ((Check) visitor.agent().getModule("Client","check")).count(
									(astra.term.Funct) visitor.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleTerm("check", Type.INTEGER,
						new Predicate("count", new Term[] {
							new Funct("refusal", new Term[] {
								new Variable(Type.STRING, "OrderId"),
								new Variable(Type.STRING, "sender2",false)
							})
						}),
						new ModuleTermAdaptor() {
							public Object invoke(Intention intention, Predicate predicate) {
								return ((Check) intention.getModule("Client","check")).count(
									(astra.term.Funct) intention.evaluate(predicate.getTerm(0))
								);
							}
							public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
								return ((Check) visitor.agent().getModule("Client","check")).count(
									(astra.term.Funct) visitor.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				)
			}),
			new Block(
				"Client", new int[] {147,155,149,5},
				new Statement[] {
					new Subgoal(
						"Client", new int[] {148,8,149,5},
						new Goal(
							new Predicate("chooseRestaurant", new Term[] {
								new Variable(Type.STRING, "OrderId")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Client", new int[] {151,9,151,38},
			new GoalEvent('+',
				new Goal(
					new Predicate("call_done", new Term[] {
						new Variable(Type.STRING, "OrderId",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Client", new int[] {151,37,151,39},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Client", new int[] {154,9,154,45},
			new GoalEvent('+',
				new Goal(
					new Predicate("chooseRestaurant", new Term[] {
						new Variable(Type.STRING, "OrderId",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Client", new int[] {154,44,195,5},
				new Statement[] {
					new ModuleCall("system",
						"Client", new int[] {155,8,155,41},
						new Predicate("sleep", new Term[] {
							Operator.newOperator('%',
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
								Primitive.newPrimitive(100)
							)
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
						new Variable(Type.STRING, "chosen_restaurant"),
						"Client", new int[] {156,8,195,5},
						Primitive.newPrimitive("")
					),
					new Query(
						"Client", new int[] {157,8,157,31},
						new Predicate("strategy", new Term[] {
							new Variable(Type.INTEGER, "St",false)
						})
					),
					new Query(
						"Client", new int[] {158,8,158,37},
						new Predicate("location", new Term[] {
							new Variable(Type.INTEGER, "X",false),
							new Variable(Type.INTEGER, "Y",false)
						})
					),
					new If(
						"Client", new int[] {159,8,195,5},
						new Comparison("==",
							new Variable(Type.INTEGER, "St"),
							Primitive.newPrimitive(0)
						),
						new Block(
							"Client", new int[] {159,19,174,9},
							new Statement[] {
								new Declaration(
									new Variable(Type.INTEGER, "price"),
									"Client", new int[] {160,12,174,9},
									Primitive.newPrimitive(9999)
								),
								new ForEach(
									"Client", new int[] {161,12,174,9},
									new Predicate("proposal", new Term[] {
										new Variable(Type.STRING, "OrderId"),
										new Variable(Type.STRING, "sender",false),
										new Variable(Type.INTEGER, "Total",false),
										new Variable(Type.DOUBLE, "S",false)
									}),
									new Block(
										"Client", new int[] {161,74,171,13},
										new Statement[] {
											new If(
												"Client", new int[] {162,16,171,13},
												new Comparison("<",
													new Variable(Type.INTEGER, "Total"),
													new Variable(Type.INTEGER, "price")
												),
												new Block(
													"Client", new int[] {162,35,168,17},
													new Statement[] {
														new If(
															"Client", new int[] {163,20,168,17},
															new Comparison("~=",
																new Variable(Type.STRING, "chosen_restaurant"),
																Primitive.newPrimitive("")
															),
															new Block(
																"Client", new int[] {163,48,165,25},
																new Statement[] {
																	new Send("Client", new int[] {164,24,164,94},
																		new Performative("reject-proposal"),
																		new Variable(Type.STRING, "chosen_restaurant"),
																		new Predicate("offer_denied", new Term[] {
																			new Variable(Type.STRING, "OrderId"),
																			new Variable(Type.INTEGER, "Total")
																		})
																	)
																}
															)
														),
														new Assignment(
															new Variable(Type.STRING, "chosen_restaurant"),
															"Client", new int[] {166,20,168,17},
															new Variable(Type.STRING, "sender")
														),
														new Assignment(
															new Variable(Type.INTEGER, "price"),
															"Client", new int[] {167,20,168,17},
															new Variable(Type.INTEGER, "Total")
														)
													}
												),
												new Block(
													"Client", new int[] {168,23,171,13},
													new Statement[] {
														new Send("Client", new int[] {169,20,169,79},
															new Performative("reject-proposal"),
															new Variable(Type.STRING, "sender"),
															new Predicate("offer_denied", new Term[] {
																new Variable(Type.STRING, "OrderId"),
																new Variable(Type.INTEGER, "Total")
															})
														)
													}
												)
											)
										}
									)
								),
								new ModuleCall("system",
									"Client", new int[] {172,8,172,41},
									new Predicate("sleep", new Term[] {
										Operator.newOperator('%',
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
											Primitive.newPrimitive(100)
										)
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
								new Send("Client", new int[] {173,8,173,86},
									new Performative("accept-proposal"),
									new Variable(Type.STRING, "chosen_restaurant"),
									new Predicate("offer_accepted", new Term[] {
										new Variable(Type.STRING, "OrderId"),
										new Variable(Type.INTEGER, "price"),
										new Variable(Type.INTEGER, "X"),
										new Variable(Type.INTEGER, "Y")
									})
								)
							}
						),
						new Block(
							"Client", new int[] {174,13,195,5},
							new Statement[] {
								new Declaration(
									new Variable(Type.INTEGER, "rate"),
									"Client", new int[] {175,12,191,9},
									Primitive.newPrimitive(-1)
								),
								new Declaration(
									new Variable(Type.INTEGER, "price"),
									"Client", new int[] {176,12,191,9},
									Primitive.newPrimitive(9999)
								),
								new ForEach(
									"Client", new int[] {177,12,191,9},
									new Predicate("proposal", new Term[] {
										new Variable(Type.STRING, "OrderId"),
										new Variable(Type.STRING, "sender",false),
										new Variable(Type.INTEGER, "Total",false),
										new Variable(Type.DOUBLE, "S",false)
									}),
									new Block(
										"Client", new int[] {177,74,188,13},
										new Statement[] {
											new If(
												"Client", new int[] {178,16,188,13},
												new Comparison(">",
													new Variable(Type.DOUBLE, "S"),
													new Variable(Type.INTEGER, "rate")
												),
												new Block(
													"Client", new int[] {178,30,185,17},
													new Statement[] {
														new If(
															"Client", new int[] {179,20,185,17},
															new Comparison("~=",
																new Variable(Type.STRING, "chosen_restaurant"),
																Primitive.newPrimitive("")
															),
															new Block(
																"Client", new int[] {179,48,181,25},
																new Statement[] {
																	new Send("Client", new int[] {180,24,180,94},
																		new Performative("reject-proposal"),
																		new Variable(Type.STRING, "chosen_restaurant"),
																		new Predicate("offer_denied", new Term[] {
																			new Variable(Type.STRING, "OrderId"),
																			new Variable(Type.INTEGER, "Total")
																		})
																	)
																}
															)
														),
														new Assignment(
															new Variable(Type.STRING, "chosen_restaurant"),
															"Client", new int[] {182,20,185,17},
															new Variable(Type.STRING, "sender")
														),
														new Assignment(
															new Variable(Type.INTEGER, "rate"),
															"Client", new int[] {183,20,185,17},
															new Variable(Type.DOUBLE, "S")
														),
														new Assignment(
															new Variable(Type.INTEGER, "price"),
															"Client", new int[] {184,20,185,17},
															new Variable(Type.INTEGER, "Total")
														)
													}
												),
												new Block(
													"Client", new int[] {185,23,188,13},
													new Statement[] {
														new Send("Client", new int[] {186,20,186,79},
															new Performative("reject-proposal"),
															new Variable(Type.STRING, "sender"),
															new Predicate("offer_denied", new Term[] {
																new Variable(Type.STRING, "OrderId"),
																new Variable(Type.INTEGER, "Total")
															})
														)
													}
												)
											)
										}
									)
								),
								new Send("Client", new int[] {190,8,190,86},
									new Performative("accept-proposal"),
									new Variable(Type.STRING, "chosen_restaurant"),
									new Predicate("offer_accepted", new Term[] {
										new Variable(Type.STRING, "OrderId"),
										new Variable(Type.INTEGER, "price"),
										new Variable(Type.INTEGER, "X"),
										new Variable(Type.INTEGER, "Y")
									})
								)
							}
						)
					),
					new ModuleCall("console",
						"Client", new int[] {192,8,192,52},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Placed order for "),
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
					new ModuleCall("system",
						"Client", new int[] {193,8,193,41},
						new Predicate("sleep", new Term[] {
							Operator.newOperator('%',
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
								Primitive.newPrimitive(100)
							)
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
					new BeliefUpdate('+',
						"Client", new int[] {194,8,195,5},
						new Predicate("placed", new Term[] {
							new Variable(Type.STRING, "OrderId")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Client", new int[] {197,9,198,26},
			new GoalEvent('+',
				new Goal(
					new Predicate("checkOrdersPlaced", new Term[] {})
				)
			),
			new Predicate("nOrders", new Term[] {
				new Variable(Type.INTEGER, "NO",false)
			}),
			new Block(
				"Client", new int[] {198,25,209,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "N"),
						"Client", new int[] {199,8,209,5},
						Operator.newOperator('+',
							new ModuleTerm("check", Type.INTEGER,
								new Predicate("count", new Term[] {
									new Funct("placed", new Term[] {
										new Variable(Type.STRING, "S1",false)
									})
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((Check) intention.getModule("Client","check")).count(
											(astra.term.Funct) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((Check) visitor.agent().getModule("Client","check")).count(
											(astra.term.Funct) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							),
							new ModuleTerm("check", Type.INTEGER,
								new Predicate("count", new Term[] {
									new Funct("notFound", new Term[] {
										new Variable(Type.STRING, "S2",false)
									})
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((Check) intention.getModule("Client","check")).count(
											(astra.term.Funct) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((Check) visitor.agent().getModule("Client","check")).count(
											(astra.term.Funct) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							)
						)
					),
					new If(
						"Client", new int[] {200,8,209,5},
						new Comparison("==",
							new Variable(Type.INTEGER, "N"),
							new Variable(Type.INTEGER, "NO")
						),
						new Block(
							"Client", new int[] {200,20,205,9},
							new Statement[] {
								new ModuleCall("console",
									"Client", new int[] {201,12,201,54},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("Placed all my orders!!!")
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
									"Client", new int[] {202,12,202,45},
									new Predicate("sleep", new Term[] {
										Operator.newOperator('%',
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
											Primitive.newPrimitive(100)
										)
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
								new Send("Client", new int[] {203,12,203,49},
									new Performative("inform"),
									Primitive.newPrimitive("main"),
									new Predicate("placedAll", new Term[] {
										Primitive.newPrimitive("ok")
									})
								),
								new Subgoal(
									"Client", new int[] {204,12,205,9},
									new Goal(
										new Predicate("checkOrdersFinished", new Term[] {})
									)
								)
							}
						),
						new Block(
							"Client", new int[] {205,14,209,5},
							new Statement[] {
								new ModuleCall("system",
									"Client", new int[] {206,12,206,26},
									new Predicate("sleep", new Term[] {
										Primitive.newPrimitive(1)
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
								new Subgoal(
									"Client", new int[] {207,12,208,9},
									new Goal(
										new Predicate("checkOrdersPlaced", new Term[] {})
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Client", new int[] {210,9,210,68},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("delivered", new Term[] {
					new Variable(Type.STRING, "OrderId",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Client", new int[] {210,67,213,5},
				new Statement[] {
					new ModuleCall("console",
						"Client", new int[] {211,8,211,44},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Received "),
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
					new BeliefUpdate('+',
						"Client", new int[] {212,8,213,5},
						new Predicate("finished", new Term[] {
							new Variable(Type.STRING, "OrderId")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Client", new int[] {215,9,216,26},
			new GoalEvent('+',
				new Goal(
					new Predicate("checkOrdersFinished", new Term[] {})
				)
			),
			new Predicate("nOrders", new Term[] {
				new Variable(Type.INTEGER, "NO",false)
			}),
			new Block(
				"Client", new int[] {216,25,226,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "N"),
						"Client", new int[] {217,8,226,5},
						Operator.newOperator('+',
							new ModuleTerm("check", Type.INTEGER,
								new Predicate("count", new Term[] {
									new Funct("finished", new Term[] {
										new Variable(Type.STRING, "S1",false)
									})
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((Check) intention.getModule("Client","check")).count(
											(astra.term.Funct) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((Check) visitor.agent().getModule("Client","check")).count(
											(astra.term.Funct) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							),
							new ModuleTerm("check", Type.INTEGER,
								new Predicate("count", new Term[] {
									new Funct("notFound", new Term[] {
										new Variable(Type.STRING, "S2",false)
									})
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((Check) intention.getModule("Client","check")).count(
											(astra.term.Funct) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((Check) visitor.agent().getModule("Client","check")).count(
											(astra.term.Funct) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							)
						)
					),
					new If(
						"Client", new int[] {218,8,226,5},
						new Comparison("==",
							new Variable(Type.INTEGER, "N"),
							new Variable(Type.INTEGER, "NO")
						),
						new Block(
							"Client", new int[] {218,20,222,9},
							new Statement[] {
								new ModuleCall("system",
									"Client", new int[] {219,12,219,45},
									new Predicate("sleep", new Term[] {
										Operator.newOperator('%',
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
											Primitive.newPrimitive(100)
										)
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
								new ModuleCall("console",
									"Client", new int[] {220,12,220,56},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("Finished all my orders!!!")
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
								new Send("Client", new int[] {221,12,221,51},
									new Performative("inform"),
									Primitive.newPrimitive("main"),
									new Predicate("finishedAll", new Term[] {
										Primitive.newPrimitive("ok")
									})
								)
							}
						),
						new Block(
							"Client", new int[] {222,14,226,5},
							new Statement[] {
								new ModuleCall("system",
									"Client", new int[] {223,12,223,26},
									new Predicate("sleep", new Term[] {
										Primitive.newPrimitive(1)
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
								new Subgoal(
									"Client", new int[] {224,12,225,9},
									new Goal(
										new Predicate("checkOrdersFinished", new Term[] {})
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
				Primitive.newPrimitive(1)
			})
		);
		agent.initialize(
			new Predicate("typesOfFood", new Term[] {
				Primitive.newPrimitive(10)
			})
		);
		agent.initialize(
			new Predicate("placed", new Term[] {
				Primitive.newPrimitive(0)
			})
		);
		agent.initialize(
			new Predicate("notFound", new Term[] {
				Primitive.newPrimitive(0)
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
				new Predicate("checkOrdersPlaced", new Term[] {})
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
		fragment.addModule("df",Df.class,agent);
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
