CKEDITOR.dialog
		.add(
				"syntaxhighlight",
				function(d) {
					var a = function(g) {
						g = g.replace(/<br>/g, "\n");
						g = g.replace(/&amp;/g, "&");
						g = g.replace(/&lt;/g, "<");
						g = g.replace(/&gt;/g, ">");
						g = g.replace(/&quot;/g, '"');
						return g
					};
					function c(g) {
						g = g.replace(/&/g, "&amp;");
						g = g.replace(/</g, "&lt;");
						g = g.replace(/>/g, "&gt;");
						return g
					}
					var f = function(g) {
						var g = new Object();
						g.hideGutter = false;
						g.hideControls = false;
						g.collapse = false;
						g.noWrap = false;
						g.noLinks = false;
						g.firstLineChecked = false;
						g.firstLine = 0;
						g.highlightChecked = false;
						g.highlight = null;
						g.lang = null;
						g.code = "";
						return g
					};
					var b = function(j) {
						var i = f();
						if (j) {
							if (j.indexOf("brush") > -1) {
								var h = /brush:[ ]{0,1}(\w*)/.exec(j);
								if (h != null && h.length > 0) {
									i.lang = h[1].replace(/^\s+|\s+$/g, "")
								}
							}
							if (j.indexOf("gutter") > -1) {
								i.hideGutter = true
							}
							if (j.indexOf("toolbar") > -1) {
								i.hideControls = true
							}
							if (j.indexOf("collapse") > -1) {
								i.collapse = true
							}
							if (j.indexOf("first-line") > -1) {
								var h = /first-line:[ ]{0,1}([0-9]{1,4})/
										.exec(j);
								if (h != null && h.length > 0 && h[1] > 1) {
									i.firstLineChecked = true;
									i.firstLine = h[1]
								}
							}
							if (j.indexOf("highlight") > -1) {
								if (j
										.match(/highlight:[ ]{0,1}\[[0-9]+(,[0-9]+)*\]/)) {
									var g = /highlight:[ ]{0,1}\[(.*)\]/
											.exec(j);
									if (g != null && g.length > 0) {
										i.highlightChecked = true;
										i.highlight = g[1]
									}
								}
							}
							if (j.indexOf("wrap-lines") > -1) {
								i.noWrap = true
							}
							if (j.indexOf("auto-links") > -1) {
								i.noLinks = true
							}
						}
						return i
					};
					var e = function(h) {
						var g = "brush:" + h.lang + ";";
						if (h.hideGutter) {
							g += "gutter:false;"
						}
						if (h.hideControls) {
							g += "toolbar:false;"
						}
						if (h.collapse) {
							g += "collapse:true;"
						}
						if (h.noWrap) {
							g += "wrap-lines:false;"
						}
						if (h.noLinks) {
							g += "auto-links:false;"
						}
						if (h.firstLineChecked && h.firstLine > 1) {
							g += "first-line:" + h.firstLine + ";"
						}
						if (h.highlightChecked && h.highlight != "") {
							g += "highlight: ["
									+ h.highlight.replace(/\s/gi, "") + "];"
						}
						return g
					};
					return {
						title : d.lang.syntaxhighlight.title,
						minWidth : 500,
						minHeight : 400,
						onShow : function() {
							var j = this.getParentEditor();
							var i = j.getSelection();
							var h = i.getStartElement();
							var l = h && h.getAscendant("pre", true);
							var k = "";
							var g = null;
							if (l) {
								code = a(l.getHtml());
								g = b(l.getAttribute("class"));
								g.code = code
							} else {
								g = f()
							}
							this.setupContent(g)
						},
						onOk : function() {
							var i = this.getParentEditor();
							var h = i.getSelection();
							var g = h.getStartElement();
							var l = g && g.getAscendant("pre", true);
							var j = f();
							this.commitContent(j);
							var k = e(j);
							var m = CKEDITOR.dom.element
									.createFromHtml('<pre class="' + k + '">'
											+ c(j.code) + "</pre>");
							if (l) {
								m.insertBefore(l);
								l.remove()
							} else {
								i.insertElement(m)
							}
						},
						contents : [
								{
									id : "source",
									label : d.lang.syntaxhighlight.sourceTab,
									elements : [
											{
												type : "vbox",
												children : [ {
													id : "cmbLang",
													type : "select",
													labelLayout : "horizontal",
													label : d.lang.syntaxhighlight.langLbl,
													"default" : "java",
													widths : [ "25%", "75%" ],
													items : [
															[ "Bash (Shell)",
																	"bash" ],
															[ "C#", "csharp" ],
															[ "C++", "cpp" ],
															[ "CSS", "css" ],
															[ "Delphi",
																	"delphi" ],
															[ "Diff", "diff" ],
															[ "Groovy",
																	"groovy" ],
															[ "Javascript",
																	"jscript" ],
															[ "Java", "java" ],
															[ "Java FX",
																	"javafx" ],
															[ "Perl", "perl" ],
															[ "PHP", "php" ],
															[ "Plain (Text)",
																	"plain" ],
															[ "Python",
																	"python" ],
															[ "Ruby", "ruby" ],
															[ "Scala", "scala" ],
															[ "SQL", "sql" ],
															[ "VB", "vb" ],
															[ "XML/XHTML",
																	"xml" ] ],
													setup : function(g) {
														if (g.lang) {
															this
																	.setValue(g.lang)
														}
													},
													commit : function(g) {
														g.lang = this
																.getValue()
													}
												} ]
											}, {
												type : "textarea",
												id : "hl_code",
												rows : 22,
												style : "width: 100%",
												setup : function(g) {
													if (g.code) {
														this.setValue(g.code)
													}
												},
												commit : function(g) {
													g.code = this.getValue()
												}
											} ]
								},
								{
									id : "advanced",
									label : d.lang.syntaxhighlight.advancedTab,
									elements : [ {
										type : "vbox",
										children : [
												{
													type : "html",
													html : "<strong>"
															+ d.lang.syntaxhighlight.hideGutter
															+ "</strong>"
												},
												{
													type : "checkbox",
													id : "hide_gutter",
													label : d.lang.syntaxhighlight.hideGutterLbl,
													setup : function(g) {
														this
																.setValue(g.hideGutter)
													},
													commit : function(g) {
														g.hideGutter = this
																.getValue()
													}
												},
												{
													type : "html",
													html : "<strong>"
															+ d.lang.syntaxhighlight.hideControls
															+ "</strong>"
												},
												{
													type : "checkbox",
													id : "hide_controls",
													label : d.lang.syntaxhighlight.hideControlsLbl,
													setup : function(g) {
														this
																.setValue(g.hideControls)
													},
													commit : function(g) {
														g.hideControls = this
																.getValue()
													}
												},
												{
													type : "html",
													html : "<strong>"
															+ d.lang.syntaxhighlight.collapse
															+ "</strong>"
												},
												{
													type : "checkbox",
													id : "collapse",
													label : d.lang.syntaxhighlight.collapseLbl,
													setup : function(g) {
														this
																.setValue(g.collapse)
													},
													commit : function(g) {
														g.collapse = this
																.getValue()
													}
												},
												{
													type : "html",
													html : "<strong>"
															+ d.lang.syntaxhighlight.lineWrap
															+ "</strong>"
												},
												{
													type : "checkbox",
													id : "line_wrap",
													label : d.lang.syntaxhighlight.lineWrapLbl,
													setup : function(g) {
														this.setValue(g.noWrap)
													},
													commit : function(g) {
														g.noWrap = this
																.getValue()
													}
												},
												{
													type : "html",
													html : "<strong>"
															+ d.lang.syntaxhighlight.autoLinks
															+ "</strong>"
												},
												{
													type : "checkbox",
													id : "auto_links",
													label : d.lang.syntaxhighlight.autoLinksLbl,
													setup : function(g) {
														this
																.setValue(g.noLinks)
													},
													commit : function(g) {
														g.noLinks = this
																.getValue()
													}
												},
												{
													type : "html",
													html : "<strong>"
															+ d.lang.syntaxhighlight.lineCount
															+ "</strong>"
												},
												{
													type : "hbox",
													widths : [ "5%", "95%" ],
													children : [
															{
																type : "checkbox",
																id : "lc_toggle",
																label : "",
																setup : function(
																		g) {
																	this
																			.setValue(g.firstLineChecked)
																},
																commit : function(
																		g) {
																	g.firstLineChecked = this
																			.getValue()
																}
															},
															{
																type : "text",
																id : "default_lc",
																style : "width: 15%;",
																label : "",
																setup : function(
																		g) {
																	if (g.firstLine > 1) {
																		this
																				.setValue(g.firstLine)
																	}
																},
																commit : function(
																		g) {
																	if (this
																			.getValue()
																			&& this
																					.getValue() != "") {
																		g.firstLine = this
																				.getValue()
																	}
																}
															} ]
												},
												{
													type : "html",
													html : "<strong>"
															+ d.lang.syntaxhighlight.highlight
															+ "</strong>"
												},
												{
													type : "hbox",
													widths : [ "5%", "95%" ],
													children : [
															{
																type : "checkbox",
																id : "hl_toggle",
																label : "",
																setup : function(
																		g) {
																	this
																			.setValue(g.highlightChecked)
																},
																commit : function(
																		g) {
																	g.highlightChecked = this
																			.getValue()
																}
															},
															{
																type : "text",
																id : "default_hl",
																style : "width: 40%;",
																label : "",
																setup : function(
																		g) {
																	if (g.highlight != null) {
																		this
																				.setValue(g.highlight)
																	}
																},
																commit : function(
																		g) {
																	if (this
																			.getValue()
																			&& this
																					.getValue() != "") {
																		g.highlight = this
																				.getValue()
																	}
																}
															} ]
												},
												{
													type : "hbox",
													widths : [ "5%", "95%" ],
													children : [
															{
																type : "html",
																html : ""
															},
															{
																type : "html",
																html : "<i>"
																		+ d.lang.syntaxhighlight.highlightLbl
																		+ "</i>"
															} ]
												} ]
									} ]
								} ]
					}
				});
