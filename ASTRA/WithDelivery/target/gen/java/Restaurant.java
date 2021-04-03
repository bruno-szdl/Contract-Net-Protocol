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
			"Restaurant", new int[] {69,9,69,39},
			new GoalEvent('+',
				new Goal(
					new Predicate("init", new Term[] {})
				)
			),
			new Predicate("typesOfFood", new Term[] {
				new Variable(Type.INTEGER, "T",false)
			}),
			new Block(
				"Restaurant", new int[] {69,38,86,9},
				new Statement[] {
					new Declaration(
						new Variable(Type.STRING, "Name"),
						"Restaurant", new int[] {70,8,86,9},
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
						"Restaurant", new int[] {71,8,86,9},
						new Predicate("name", new Term[] {
							new Variable(Type.STRING, "Name")
						})
					),
					new ModuleCall("console",
						"Restaurant", new int[] {72,8,72,43},
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
						"Restaurant", new int[] {73,8,86,9},
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
						"Restaurant", new int[] {74,8,74,60},
						new Predicate("food", new Term[] {
							new Variable(Type.INTEGER, "R"),
							new Variable(Type.STRING, "F",false),
							new Variable(Type.INTEGER, "minPrice",false),
							new Variable(Type.INTEGER, "maxPrice",false)
						})
					),
					new ModuleCall("df",
						"Restaurant", new int[] {75,8,75,22},
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
						"Restaurant", new int[] {76,8,86,9},
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
						"Restaurant", new int[] {77,9,77,61},
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
						"Restaurant", new int[] {78,9,86,9},
						new Predicate("price", new Term[] {
							new Variable(Type.INTEGER, "P")
						})
					),
					new BeliefUpdate('+',
						"Restaurant", new int[] {79,9,86,9},
						new Predicate("serve", new Term[] {
							new Variable(Type.STRING, "F")
						})
					),
					new BeliefUpdate('-',
						"Restaurant", new int[] {80,8,86,9},
						new Predicate("typesOfFood", new Term[] {
							new Variable(Type.INTEGER, "T")
						})
					),
					new Declaration(
						new Variable(Type.INTEGER, "X"),
						"Restaurant", new int[] {81,8,86,9},
						Primitive.newPrimitive(0)
					),
					new While(
						"Restaurant", new int[] {82,8,86,9},
						new Comparison("<",
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "T")
						),
						new Block(
							"Restaurant", new int[] {82,20,85,13},
							new Statement[] {
								new BeliefUpdate('-',
									"Restaurant", new int[] {83,12,85,13},
									new Predicate("food", new Term[] {
										new Variable(Type.INTEGER, "X"),
										new Variable(Type.STRING, "S",false),
										new Variable(Type.INTEGER, "I",false),
										new Variable(Type.INTEGER, "J",false)
									})
								),
								new Assignment(
									new Variable(Type.INTEGER, "X"),
									"Restaurant", new int[] {84,12,85,13},
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
			"Restaurant", new int[] {88,9,88,25},
			new GoalEvent('+',
				new Goal(
					new Predicate("getLocation", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Restaurant", new int[] {88,24,96,9},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "X"),
						"Restaurant", new int[] {89,8,96,9},
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
						"Restaurant", new int[] {90,8,96,9},
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
						"Restaurant", new int[] {91,8,96,9},
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
						"Restaurant", new int[] {92,8,96,9},
						Operator.newOperator('*',
							Operator.newOperator('-',
								Primitive.newPrimitive(80),
								Primitive.newPrimitive(60)
							),
							new Variable(Type.INTEGER, "R")
						)
					),
					new BeliefUpdate('+',
						"Restaurant", new int[] {93,8,96,9},
						new Predicate("location", new Term[] {
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "Y")
						})
					),
					new BeliefUpdate('+',
						"Restaurant", new int[] {94,8,96,9},
						new Predicate("radius", new Term[] {
							new Variable(Type.INTEGER, "Radius")
						})
					),
					new ModuleCall("console",
						"Restaurant", new int[] {95,8,95,99},
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
			"Restaurant", new int[] {98,9,98,21},
			new GoalEvent('+',
				new Goal(
					new Predicate("getRate", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Restaurant", new int[] {98,20,101,9},
				new Statement[] {
					new Declaration(
						new Variable(Type.DOUBLE, "S"),
						"Restaurant", new int[] {99,8,101,9},
						Primitive.newPrimitive(5.0)
					),
					new BeliefUpdate('+',
						"Restaurant", new int[] {100,8,101,9},
						new Predicate("rate", new Term[] {
							new Variable(Type.DOUBLE, "S")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Restaurant", new int[] {105,9,105,78},
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
				"Restaurant", new int[] {105,77,120,9},
				new Statement[] {
					new Query(
						"Restaurant", new int[] {106,8,106,39},
						new Predicate("location", new Term[] {
							new Variable(Type.INTEGER, "XR",false),
							new Variable(Type.INTEGER, "YR",false)
						})
					),
					new Query(
						"Restaurant", new int[] {107,8,107,29},
						new Predicate("radius", new Term[] {
							new Variable(Type.INTEGER, "Rd",false)
						})
					),
					new Query(
						"Restaurant", new int[] {108,8,108,27},
						new Predicate("price", new Term[] {
							new Variable(Type.INTEGER, "P",false)
						})
					),
					new Query(
						"Restaurant", new int[] {109,8,109,29},
						new Predicate("rate", new Term[] {
							new Variable(Type.DOUBLE, "S",false)
						})
					),
					new Declaration(
						new Variable(Type.INTEGER, "distance"),
						"Restaurant", new int[] {110,8,120,9},
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
						"Restaurant", new int[] {111,8,120,9},
						new Comparison("<",
							new Variable(Type.INTEGER, "distance"),
							new Variable(Type.INTEGER, "Rd")
						),
						new Block(
							"Restaurant", new int[] {111,26,116,9},
							new Statement[] {
								new Declaration(
									new Variable(Type.INTEGER, "Total"),
									"Restaurant", new int[] {112,12,116,9},
									Operator.newOperator('/',
										new Variable(Type.INTEGER, "distance"),
										Operator.newOperator('+',
											Primitive.newPrimitive(2),
											new Variable(Type.INTEGER, "P")
										)
									)
								),
								new Send("Restaurant", new int[] {115,12,115,65},
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
							"Restaurant", new int[] {116,14,120,9},
							new Statement[] {
								new Send("Restaurant", new int[] {118,12,118,53},
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
			"Restaurant", new int[] {122,9,122,92},
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
				"Restaurant", new int[] {122,91,124,5},
				new Statement[] {
					new Send("Restaurant", new int[] {123,8,123,40},
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
			"Restaurant", new int[] {126,9,126,108},
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
				"Restaurant", new int[] {126,107,132,5},
				new Statement[] {
					new Query(
						"Restaurant", new int[] {128,8,128,27},
						new Predicate("sells", new Term[] {
							new Variable(Type.INTEGER, "S",false)
						})
					),
					new SpecialBeliefUpdate(
						"Restaurant", new int[] {129,8,132,5},
						new Predicate("sells", new Term[] {
							Operator.newOperator('+',
								new Variable(Type.INTEGER, "S"),
								Primitive.newPrimitive(1)
							)
						})
					),
					new Send("Restaurant", new int[] {130,8,130,48},
						new Performative("inform"),
						new Variable(Type.STRING, "sender"),
						new Predicate("preparing", new Term[] {
							new Variable(Type.STRING, "OrderId")
						})
					),
					new BeliefUpdate('+',
						"Restaurant", new int[] {131,8,132,5},
						new Predicate("needToDeliver", new Term[] {
							new Variable(Type.STRING, "OrderId"),
							new Variable(Type.STRING, "sender"),
							new Variable(Type.INTEGER, "X"),
							new Variable(Type.INTEGER, "Y")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"Restaurant", new int[] {136,9,136,82},
			new BeliefEvent('+',
				new Predicate("needToDeliver", new Term[] {
					new Variable(Type.STRING, "OrderId",false),
					new Variable(Type.STRING, "client",false),
					new Variable(Type.INTEGER, "Xclient",false),
					new Variable(Type.INTEGER, "Yclient",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Restaurant", new int[] {136,81,139,9},
				new Statement[] {
					new Subgoal(
						"Restaurant", new int[] {138,12,139,9},
						new Goal(
							new Predicate("callForDeliveryMen", new Term[] {
								new Variable(Type.STRING, "OrderId")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Restaurant", new int[] {141,9,141,47},
			new GoalEvent('+',
				new Goal(
					new Predicate("callForDeliveryMen", new Term[] {
						new Variable(Type.STRING, "OrderId",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Restaurant", new int[] {141,46,160,9},
				new Statement[] {
					new While(
						"Restaurant", new int[] {142,12,160,9},
						new Predicate("proposal", new Term[] {
							new Variable(Type.STRING, "OrderId"),
							new Variable(Type.STRING, "sender",false),
							new Variable(Type.INTEGER, "Distance",false)
						}),
						new Block(
							"Restaurant", new int[] {142,66,144,13},
							new Statement[] {
								new BeliefUpdate('-',
									"Restaurant", new int[] {143,16,144,13},
									new Predicate("proposal", new Term[] {
										new Variable(Type.STRING, "OrderId"),
										new Variable(Type.STRING, "sender"),
										new Variable(Type.INTEGER, "Distance")
									})
								)
							}
						)
					),
					new While(
						"Restaurant", new int[] {145,12,160,9},
						new Predicate("refusal", new Term[] {
							new Variable(Type.STRING, "OrderId"),
							new Variable(Type.STRING, "sender2",false)
						}),
						new Block(
							"Restaurant", new int[] {145,52,147,13},
							new Statement[] {
								new BeliefUpdate('-',
									"Restaurant", new int[] {146,16,147,13},
									new Predicate("refusal", new Term[] {
										new Variable(Type.STRING, "OrderId"),
										new Variable(Type.STRING, "sender2")
									})
								)
							}
						)
					),
					new ModuleCall("df",
						"Restaurant", new int[] {149,12,149,45},
						new Predicate("search", new Term[] {
							Primitive.newPrimitive("deliveryman"),
							new Variable(Type.LIST, "LD",false)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((Df) intention.getModule("Restaurant","df")).search(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(ActionParam<astra.term.ListTerm>) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new BeliefUpdate('+',
						"Restaurant", new int[] {150,12,160,9},
						new Predicate("delivery_man_count", new Term[] {
							new Variable(Type.STRING, "OrderId"),
							new Count(
								new Variable(Type.LIST, "LD")
							)
						})
					),
					new If(
						"Restaurant", new int[] {152,12,160,9},
						new Comparison("==",
							new Variable(Type.LIST, "LD"),
							new ListTerm(new Term[] {

							})
						),
						new Block(
							"Restaurant", new int[] {152,25,156,13},
							new Statement[] {
								new ModuleCall("console",
									"Restaurant", new int[] {153,16,153,68},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("No deliveryman found for "),
											new Variable(Type.STRING, "OrderId")
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
								new ModuleCall("system",
									"Restaurant", new int[] {155,16,155,29},
									new Predicate("exit", new Term[] {}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.System) intention.getModule("Restaurant","system")).exit(
											);
										}
									}
								)
							}
						),
						new Block(
							"Restaurant", new int[] {156,18,160,9},
							new Statement[] {
								new Query(
									"Restaurant", new int[] {157,12,157,41},
									new Predicate("location", new Term[] {
										new Variable(Type.INTEGER, "X",false),
										new Variable(Type.INTEGER, "Y",false)
									})
								),
								new Send("Restaurant", new int[] {158,12,158,49},
									new Performative("cfp"),
									new Variable(Type.LIST, "LD"),
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
			"Restaurant", new int[] {162,9,162,94},
			new MessageEvent(
				new Performative("propose"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("sendProposeDelivery", new Term[] {
					new Variable(Type.STRING, "OrderId",false),
					new Variable(Type.INTEGER, "Distance",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Restaurant", new int[] {162,93,166,5},
				new Statement[] {
					new BeliefUpdate('+',
						"Restaurant", new int[] {163,8,166,5},
						new Predicate("proposal", new Term[] {
							new Variable(Type.STRING, "OrderId"),
							new Variable(Type.STRING, "sender"),
							new Variable(Type.INTEGER, "Distance")
						})
					),
					new Subgoal(
						"Restaurant", new int[] {165,8,166,5},
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
			"Restaurant", new int[] {168,9,168,78},
			new MessageEvent(
				new Performative("refuse"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("sendRefuseDelivery", new Term[] {
					new Variable(Type.STRING, "OrderId",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Restaurant", new int[] {168,77,172,5},
				new Statement[] {
					new BeliefUpdate('+',
						"Restaurant", new int[] {169,8,172,5},
						new Predicate("refusal", new Term[] {
							new Variable(Type.STRING, "OrderId"),
							new Variable(Type.STRING, "sender")
						})
					),
					new Subgoal(
						"Restaurant", new int[] {171,8,172,5},
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
			"Restaurant", new int[] {174,9,175,151},
			new GoalEvent('+',
				new Goal(
					new Predicate("call_done", new Term[] {
						new Variable(Type.STRING, "OrderId",false)
					})
				)
			),
			new Predicate("delivery_man_count", new Term[] {
				new Variable(Type.STRING, "OrderId"),
				Operator.newOperator('+',
					new ModuleTerm("check", Type.INTEGER,
						new Predicate("count", new Term[] {
							new Funct("proposal", new Term[] {
								new Variable(Type.STRING, "OrderId"),
								new Variable(Type.STRING, "sender",false),
								new Variable(Type.INTEGER, "Distance",false)
							})
						}),
						new ModuleTermAdaptor() {
							public Object invoke(Intention intention, Predicate predicate) {
								return ((Check) intention.getModule("Restaurant","check")).count(
									(astra.term.Funct) intention.evaluate(predicate.getTerm(0))
								);
							}
							public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
								return ((Check) visitor.agent().getModule("Restaurant","check")).count(
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
								return ((Check) intention.getModule("Restaurant","check")).count(
									(astra.term.Funct) intention.evaluate(predicate.getTerm(0))
								);
							}
							public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
								return ((Check) visitor.agent().getModule("Restaurant","check")).count(
									(astra.term.Funct) visitor.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				)
			}),
			new Block(
				"Restaurant", new int[] {175,150,184,5},
				new Statement[] {
					new If(
						"Restaurant", new int[] {176,8,184,5},
						new Comparison("<",
							new ModuleTerm("check", Type.INTEGER,
								new Predicate("count", new Term[] {
									new Funct("proposal", new Term[] {
										new Variable(Type.STRING, "OrderId"),
										new Variable(Type.STRING, "sender"),
										new Variable(Type.INTEGER, "Distance")
									})
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((Check) intention.getModule("Restaurant","check")).count(
											(astra.term.Funct) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((Check) visitor.agent().getModule("Restaurant","check")).count(
											(astra.term.Funct) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							),
							Primitive.newPrimitive(1)
						),
						new Block(
							"Restaurant", new int[] {176,64,180,9},
							new Statement[] {
								new ModuleCall("system",
									"Restaurant", new int[] {177,12,177,27},
									new Predicate("sleep", new Term[] {
										Primitive.newPrimitive(10)
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
								new ModuleCall("console",
									"Restaurant", new int[] {178,12,178,76},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("No available delivery man, searching again...")
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
								new Subgoal(
									"Restaurant", new int[] {179,12,180,9},
									new Goal(
										new Predicate("callForDeliveryMen", new Term[] {
											new Variable(Type.STRING, "OrderId")
										})
									)
								)
							}
						),
						new Block(
							"Restaurant", new int[] {180,14,184,5},
							new Statement[] {
								new ModuleCall("console",
									"Restaurant", new int[] {181,12,181,55},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("Choosing delivery man...")
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
								new Subgoal(
									"Restaurant", new int[] {182,12,183,9},
									new Goal(
										new Predicate("chooseDeliveryMan", new Term[] {
											new Variable(Type.STRING, "OrderId")
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
			"Restaurant", new int[] {186,9,186,38},
			new GoalEvent('+',
				new Goal(
					new Predicate("call_done", new Term[] {
						new Variable(Type.STRING, "OrderId",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Restaurant", new int[] {186,37,186,39},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Restaurant", new int[] {189,9,189,46},
			new GoalEvent('+',
				new Goal(
					new Predicate("chooseDeliveryMan", new Term[] {
						new Variable(Type.STRING, "OrderId",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Restaurant", new int[] {189,45,206,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.STRING, "chosen_deliveryman"),
						"Restaurant", new int[] {190,8,206,5},
						Primitive.newPrimitive("")
					),
					new Declaration(
						new Variable(Type.INTEGER, "distance"),
						"Restaurant", new int[] {191,8,206,5},
						Primitive.newPrimitive(9999)
					),
					new ForEach(
						"Restaurant", new int[] {192,8,206,5},
						new Predicate("proposal", new Term[] {
							new Variable(Type.STRING, "OrderId"),
							new Variable(Type.STRING, "sender",false),
							new Variable(Type.INTEGER, "D",false)
						}),
						new Block(
							"Restaurant", new int[] {192,56,202,9},
							new Statement[] {
								new If(
									"Restaurant", new int[] {193,12,202,9},
									new Comparison("<",
										new Variable(Type.INTEGER, "D"),
										new Variable(Type.INTEGER, "distance")
									),
									new Block(
										"Restaurant", new int[] {193,30,199,13},
										new Statement[] {
											new If(
												"Restaurant", new int[] {194,16,199,13},
												new Comparison("~=",
													new Variable(Type.STRING, "chosen_deliveryman"),
													Primitive.newPrimitive("")
												),
												new Block(
													"Restaurant", new int[] {194,45,196,21},
													new Statement[] {
														new Send("Restaurant", new int[] {195,20,195,95},
															new Performative("reject-proposal"),
															new Variable(Type.STRING, "chosen_deliveryman"),
															new Predicate("offer_deniedDelivery", new Term[] {
																new Variable(Type.STRING, "OrderId"),
																new Variable(Type.INTEGER, "D")
															})
														)
													}
												)
											),
											new Assignment(
												new Variable(Type.STRING, "chosen_deliveryman"),
												"Restaurant", new int[] {197,16,199,13},
												new Variable(Type.STRING, "sender")
											),
											new Assignment(
												new Variable(Type.INTEGER, "distance"),
												"Restaurant", new int[] {198,16,199,13},
												new Variable(Type.INTEGER, "D")
											)
										}
									),
									new Block(
										"Restaurant", new int[] {199,19,202,9},
										new Statement[] {
											new Send("Restaurant", new int[] {200,16,200,79},
												new Performative("reject-proposal"),
												new Variable(Type.STRING, "sender"),
												new Predicate("offer_deniedDelivery", new Term[] {
													new Variable(Type.STRING, "OrderId"),
													new Variable(Type.INTEGER, "D")
												})
											)
										}
									)
								)
							}
						)
					),
					new Send("Restaurant", new int[] {204,8,204,92},
						new Performative("accept-proposal"),
						new Variable(Type.STRING, "chosen_deliveryman"),
						new Predicate("offer_acceptedDelivery", new Term[] {
							new Variable(Type.STRING, "OrderId"),
							new Variable(Type.INTEGER, "distance")
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
