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
			"Client", new int[] {62,9,64,23},
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
				"Client", new int[] {64,22,87,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.STRING, "Name"),
						"Client", new int[] {65,8,87,5},
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
						"Client", new int[] {66,8,87,5},
						new Predicate("name", new Term[] {
							new Variable(Type.STRING, "Name")
						})
					),
					new ModuleCall("console",
						"Client", new int[] {67,8,67,43},
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
						"Client", new int[] {68,8,87,5},
						Primitive.newPrimitive(0)
					),
					new While(
						"Client", new int[] {69,8,87,5},
						new Comparison("<",
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "N")
						),
						new Block(
							"Client", new int[] {69,20,77,9},
							new Statement[] {
								new Assignment(
									new Variable(Type.INTEGER, "X"),
									"Client", new int[] {70,12,77,9},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "X"),
										Primitive.newPrimitive(1)
									)
								),
								new Declaration(
									new Variable(Type.INTEGER, "R"),
									"Client", new int[] {71,12,77,9},
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
									"Client", new int[] {72,12,72,36},
									new Predicate("food", new Term[] {
										new Variable(Type.INTEGER, "R"),
										new Variable(Type.STRING, "F",false)
									})
								),
								new Declaration(
									new Variable(Type.STRING, "OrderId"),
									"Client", new int[] {73,12,77,9},
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
									"Client", new int[] {74,12,77,9},
									new Predicate("orderId", new Term[] {
										new Variable(Type.STRING, "OrderId")
									})
								),
								new BeliefUpdate('+',
									"Client", new int[] {75,12,77,9},
									new Predicate("wantToOrder", new Term[] {
										new Variable(Type.STRING, "OrderId"),
										new Variable(Type.STRING, "F")
									})
								),
								new ModuleCall("console",
									"Client", new int[] {76,12,76,54},
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
						"Client", new int[] {78,8,78,56},
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
						"Client", new int[] {79,8,87,5},
						new Predicate("typesOfFood", new Term[] {
							new Variable(Type.INTEGER, "T")
						})
					),
					new While(
						"Client", new int[] {80,8,87,5},
						new Predicate("food", new Term[] {
							new Variable(Type.INTEGER, "Y",false),
							new Variable(Type.STRING, "S",false)
						}),
						new Block(
							"Client", new int[] {80,36,82,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Client", new int[] {81,12,82,9},
									new Predicate("food", new Term[] {
										new Variable(Type.INTEGER, "Y"),
										new Variable(Type.STRING, "S")
									})
								)
							}
						)
					),
					new Subgoal(
						"Client", new int[] {83,8,87,5},
						new Goal(
							new Predicate("getLocation", new Term[] {})
						)
					),
					new Subgoal(
						"Client", new int[] {84,8,87,5},
						new Goal(
							new Predicate("getStrategy", new Term[] {})
						)
					),
					new ModuleCall("system",
						"Client", new int[] {85,8,85,22},
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
						"Client", new int[] {86,8,87,5},
						new Goal(
							new Predicate("placeOrders", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Client", new int[] {89,9,89,25},
			new GoalEvent('+',
				new Goal(
					new Predicate("getLocation", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Client", new int[] {89,24,94,9},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "X"),
						"Client", new int[] {90,8,94,9},
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
						"Client", new int[] {91,8,94,9},
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
						"Client", new int[] {92,8,94,9},
						new Predicate("location", new Term[] {
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "Y")
						})
					),
					new ModuleCall("console",
						"Client", new int[] {93,8,93,64},
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
			"Client", new int[] {96,9,96,25},
			new GoalEvent('+',
				new Goal(
					new Predicate("getStrategy", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Client", new int[] {96,24,100,9},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "S"),
						"Client", new int[] {97,8,100,9},
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
						"Client", new int[] {98,8,100,9},
						new Predicate("strategy", new Term[] {
							new Variable(Type.INTEGER, "S")
						})
					),
					new ModuleCall("console",
						"Client", new int[] {99,8,99,38},
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
			"Client", new int[] {102,9,103,33},
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
				"Client", new int[] {103,32,109,9},
				new Statement[] {
					new While(
						"Client", new int[] {104,12,109,9},
						new Predicate("wantToOrder", new Term[] {
							new Variable(Type.STRING, "OrderId",false),
							new Variable(Type.STRING, "F",false)
						}),
						new Block(
							"Client", new int[] {104,56,108,13},
							new Statement[] {
								new BeliefUpdate('-',
									"Client", new int[] {105,16,108,13},
									new Predicate("wantToOrder", new Term[] {
										new Variable(Type.STRING, "OrderId"),
										new Variable(Type.STRING, "F")
									})
								),
								new SpawnGoal(
									"Client", new int[] {107,16,108,13},
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
			"Client", new int[] {111,9,111,56},
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
				"Client", new int[] {111,55,114,9},
				new Statement[] {
					new Subgoal(
						"Client", new int[] {113,12,114,9},
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
			"Client", new int[] {116,9,116,71},
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
				"Client", new int[] {116,70,129,9},
				new Statement[] {
					new ModuleCall("df",
						"Client", new int[] {118,12,118,33},
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
						"Client", new int[] {119,12,129,9},
						new Predicate("restaurant_count", new Term[] {
							new Variable(Type.STRING, "OrderId"),
							new Count(
								new Variable(Type.LIST, "LR")
							)
						})
					),
					new If(
						"Client", new int[] {121,12,129,9},
						new Comparison("==",
							new Variable(Type.LIST, "LR"),
							new ListTerm(new Term[] {
								Primitive.newPrimitive("register")
							})
						),
						new Block(
							"Client", new int[] {121,35,126,13},
							new Statement[] {
								new BeliefUpdate('+',
									"Client", new int[] {124,16,126,13},
									new Predicate("notFound", new Term[] {
										new Variable(Type.STRING, "OrderId")
									})
								)
							}
						),
						new Block(
							"Client", new int[] {126,18,129,9},
							new Statement[] {
								new Send("Client", new int[] {127,12,127,49},
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
			"Client", new int[] {131,9,131,93},
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
				"Client", new int[] {131,92,135,5},
				new Statement[] {
					new BeliefUpdate('+',
						"Client", new int[] {132,8,135,5},
						new Predicate("proposal", new Term[] {
							new Variable(Type.STRING, "OrderId"),
							new Variable(Type.STRING, "sender"),
							new Variable(Type.INTEGER, "Total"),
							new Variable(Type.DOUBLE, "S")
						})
					),
					new Subgoal(
						"Client", new int[] {134,8,135,5},
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
			"Client", new int[] {137,9,137,70},
			new MessageEvent(
				new Performative("refuse"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("sendRefuse", new Term[] {
					new Variable(Type.STRING, "OrderId",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Client", new int[] {137,69,141,5},
				new Statement[] {
					new BeliefUpdate('+',
						"Client", new int[] {138,8,141,5},
						new Predicate("refusal", new Term[] {
							new Variable(Type.STRING, "OrderId"),
							new Variable(Type.STRING, "sender")
						})
					),
					new Subgoal(
						"Client", new int[] {140,8,141,5},
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
			"Client", new int[] {143,9,144,156},
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
				"Client", new int[] {144,155,146,5},
				new Statement[] {
					new Subgoal(
						"Client", new int[] {145,8,146,5},
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
			"Client", new int[] {148,9,148,38},
			new GoalEvent('+',
				new Goal(
					new Predicate("call_done", new Term[] {
						new Variable(Type.STRING, "OrderId",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Client", new int[] {148,37,148,39},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Client", new int[] {151,9,151,45},
			new GoalEvent('+',
				new Goal(
					new Predicate("chooseRestaurant", new Term[] {
						new Variable(Type.STRING, "OrderId",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Client", new int[] {151,44,192,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.STRING, "chosen_restaurant"),
						"Client", new int[] {152,8,192,5},
						Primitive.newPrimitive("")
					),
					new Query(
						"Client", new int[] {153,8,153,31},
						new Predicate("strategy", new Term[] {
							new Variable(Type.INTEGER, "St",false)
						})
					),
					new Query(
						"Client", new int[] {154,8,154,37},
						new Predicate("location", new Term[] {
							new Variable(Type.INTEGER, "X",false),
							new Variable(Type.INTEGER, "Y",false)
						})
					),
					new If(
						"Client", new int[] {155,8,192,5},
						new Comparison("==",
							new Variable(Type.INTEGER, "St"),
							Primitive.newPrimitive(0)
						),
						new Block(
							"Client", new int[] {155,19,170,9},
							new Statement[] {
								new Declaration(
									new Variable(Type.INTEGER, "price"),
									"Client", new int[] {156,12,170,9},
									Primitive.newPrimitive(9999)
								),
								new ForEach(
									"Client", new int[] {157,12,170,9},
									new Predicate("proposal", new Term[] {
										new Variable(Type.STRING, "OrderId"),
										new Variable(Type.STRING, "sender",false),
										new Variable(Type.INTEGER, "Total",false),
										new Variable(Type.DOUBLE, "S",false)
									}),
									new Block(
										"Client", new int[] {157,74,167,13},
										new Statement[] {
											new If(
												"Client", new int[] {158,16,167,13},
												new Comparison("<",
													new Variable(Type.INTEGER, "Total"),
													new Variable(Type.INTEGER, "price")
												),
												new Block(
													"Client", new int[] {158,35,164,17},
													new Statement[] {
														new If(
															"Client", new int[] {159,20,164,17},
															new Comparison("~=",
																new Variable(Type.STRING, "chosen_restaurant"),
																Primitive.newPrimitive("")
															),
															new Block(
																"Client", new int[] {159,48,161,25},
																new Statement[] {
																	new Send("Client", new int[] {160,24,160,94},
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
															"Client", new int[] {162,20,164,17},
															new Variable(Type.STRING, "sender")
														),
														new Assignment(
															new Variable(Type.INTEGER, "price"),
															"Client", new int[] {163,20,164,17},
															new Variable(Type.INTEGER, "Total")
														)
													}
												),
												new Block(
													"Client", new int[] {164,23,167,13},
													new Statement[] {
														new Send("Client", new int[] {165,20,165,79},
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
								new Send("Client", new int[] {169,8,169,86},
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
							"Client", new int[] {170,13,192,5},
							new Statement[] {
								new Declaration(
									new Variable(Type.INTEGER, "rate"),
									"Client", new int[] {171,12,187,9},
									Primitive.newPrimitive(-1)
								),
								new Declaration(
									new Variable(Type.INTEGER, "price"),
									"Client", new int[] {172,12,187,9},
									Primitive.newPrimitive(9999)
								),
								new ForEach(
									"Client", new int[] {173,12,187,9},
									new Predicate("proposal", new Term[] {
										new Variable(Type.STRING, "OrderId"),
										new Variable(Type.STRING, "sender",false),
										new Variable(Type.INTEGER, "Total",false),
										new Variable(Type.DOUBLE, "S",false)
									}),
									new Block(
										"Client", new int[] {173,74,184,13},
										new Statement[] {
											new If(
												"Client", new int[] {174,16,184,13},
												new Comparison(">",
													new Variable(Type.DOUBLE, "S"),
													new Variable(Type.INTEGER, "rate")
												),
												new Block(
													"Client", new int[] {174,30,181,17},
													new Statement[] {
														new If(
															"Client", new int[] {175,20,181,17},
															new Comparison("~=",
																new Variable(Type.STRING, "chosen_restaurant"),
																Primitive.newPrimitive("")
															),
															new Block(
																"Client", new int[] {175,48,177,25},
																new Statement[] {
																	new Send("Client", new int[] {176,24,176,94},
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
															"Client", new int[] {178,20,181,17},
															new Variable(Type.STRING, "sender")
														),
														new Assignment(
															new Variable(Type.INTEGER, "rate"),
															"Client", new int[] {179,20,181,17},
															new Variable(Type.DOUBLE, "S")
														),
														new Assignment(
															new Variable(Type.INTEGER, "price"),
															"Client", new int[] {180,20,181,17},
															new Variable(Type.INTEGER, "Total")
														)
													}
												),
												new Block(
													"Client", new int[] {181,23,184,13},
													new Statement[] {
														new Send("Client", new int[] {182,20,182,79},
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
								new Send("Client", new int[] {186,8,186,86},
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
					new BeliefUpdate('+',
						"Client", new int[] {190,8,192,5},
						new Predicate("placed", new Term[] {
							new Variable(Type.STRING, "OrderId")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Client", new int[] {194,9,195,26},
			new GoalEvent('+',
				new Goal(
					new Predicate("checkOrdersPlaced", new Term[] {})
				)
			),
			new Predicate("nOrders", new Term[] {
				new Variable(Type.INTEGER, "NO",false)
			}),
			new Block(
				"Client", new int[] {195,25,204,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "N"),
						"Client", new int[] {196,8,204,5},
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
						"Client", new int[] {197,8,204,5},
						new Comparison("==",
							new Variable(Type.INTEGER, "N"),
							new Variable(Type.INTEGER, "NO")
						),
						new Block(
							"Client", new int[] {197,20,200,9},
							new Statement[] {
								new ModuleCall("console",
									"Client", new int[] {198,12,198,54},
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
								new Send("Client", new int[] {199,12,199,49},
									new Performative("inform"),
									Primitive.newPrimitive("main"),
									new Predicate("placedAll", new Term[] {
										Primitive.newPrimitive("ok")
									})
								)
							}
						),
						new Block(
							"Client", new int[] {200,14,204,5},
							new Statement[] {
								new Subgoal(
									"Client", new int[] {202,12,203,9},
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
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("nOrders", new Term[] {
				Primitive.newPrimitive(10)
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
