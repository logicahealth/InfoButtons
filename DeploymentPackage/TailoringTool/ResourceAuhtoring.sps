<?xml version="1.0" encoding="UTF-8"?>
<structure version="16" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces/>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="ResourceProfile-v2.8_LITE.xsd" workingxmlfile="C:\Users\gdelfiol\Google Drive\Guilherme\OpenInfobutton\Resources\V2.6\1_UpToDate.xml" templatexmlfile="ResourceProfile.xml"/>
		</schemasources>
	</schemasources>
	<modules/>
	<flags>
		<scripts/>
		<mainparts/>
		<globalparts/>
		<designfragments/>
		<pagelayouts/>
		<xpath-functions/>
	</flags>
	<scripts>
		<script language="javascript"/>
	</scripts>
	<script-project>
		<Project version="2" app="AuthenticView"/>
	</script-project>
	<importedxslt/>
	<globalstyles/>
	<mainparts>
		<children>
			<globaltemplate subtype="main" match="/">
				<document-properties/>
				<children>
					<documentsection>
						<properties columncount="1" columngap="0.50in" headerfooterheight="fixed" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.30in" papermarginheader="0.30in" papermarginleft="0.60in" papermarginright="0.60in" papermargintop="0.79in" paperwidth="8.50in"/>
					</documentsection>
					<template subtype="source" match="XML">
						<children>
							<template subtype="element" match="knowledgeResourceProfile">
								<children>
									<image>
										<styles height="40%" width="40%"/>
										<target>
											<fixtext value="http://sites.google.com/site/infobuttonsforcprs/_/rsrc/1290202364539/home/project_logo.jpg"/>
										</target>
									</image>
									<paragraph paragraphtag="p">
										<styles margin-top="1pt" text-align="center"/>
										<children>
											<text fixtext="Knowledge Resource Profile Configuration">
												<styles font-family="Verdana" font-size="14pt" font-weight="bold" text-decoration="underline"/>
											</text>
										</children>
									</paragraph>
									<paragraph paragraphtag="fieldset">
										<styles background-color="#ffffe9" font-family="Verdana" font-size="11pt"/>
										<children>
											<tgrid>
												<properties border="1"/>
												<styles width="100%"/>
												<children>
													<tgridheader-cols>
														<children>
															<tgridcol>
																<styles width="10%"/>
															</tgridcol>
														</children>
													</tgridheader-cols>
													<tgridbody-cols>
														<children>
															<template subtype="element" match="header">
																<children>
																	<tgridcol>
																		<styles width="10%"/>
																	</tgridcol>
																	<tgridcol>
																		<styles width="80%"/>
																	</tgridcol>
																</children>
																<variables/>
															</template>
														</children>
													</tgridbody-cols>
													<tgridbody-rows>
														<children>
															<tgridrow>
																<children>
																	<tgridcell>
																		<styles text-align="left"/>
																		<children>
																			<text fixtext="Resource ID"/>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<children>
																			<template subtype="attribute" match="id">
																				<children>
																					<content subtype="regular">
																						<format basic-type="xsd" datatype="integer"/>
																					</content>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</tgridcell>
																	<tgridcell joinleft="1"/>
																</children>
															</tgridrow>
															<tgridrow>
																<children>
																	<tgridcell>
																		<styles text-align="left"/>
																		<children>
																			<text fixtext="Resource Name"/>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<children>
																			<template subtype="element" match="title">
																				<children>
																					<content subtype="regular">
																						<styles color="blue" font-weight="bold"/>
																					</content>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</tgridcell>
																	<tgridcell joinleft="1"/>
																</children>
															</tgridrow>
															<tgridrow>
																<children>
																	<tgridcell>
																		<styles text-align="left"/>
																		<children>
																			<text fixtext="Profile Description"/>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<children>
																			<template subtype="element" match="profileDescription">
																				<children>
																					<content subtype="regular"/>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</tgridcell>
																	<tgridcell joinleft="1"/>
																</children>
															</tgridrow>
															<tgridrow>
																<children>
																	<tgridcell>
																		<styles text-align="left"/>
																		<children>
																			<text fixtext="Publication Date"/>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<children>
																			<template subtype="element" match="versionControl">
																				<children>
																					<template subtype="attribute" match="publicationDate">
																						<children>
																							<content subtype="regular">
																								<format basic-type="xsd" datatype="dateTime"/>
																							</content>
																							<button>
																								<action>
																									<datepicker/>
																								</action>
																							</button>
																						</children>
																						<variables/>
																					</template>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</tgridcell>
																	<tgridcell joinleft="1"/>
																</children>
															</tgridrow>
															<tgridrow>
																<children>
																	<tgridcell>
																		<styles text-align="left"/>
																	</tgridcell>
																	<tgridcell/>
																	<tgridcell>
																		<children>
																			<newline/>
																		</children>
																	</tgridcell>
																</children>
															</tgridrow>
														</children>
													</tgridbody-rows>
												</children>
											</tgrid>
										</children>
									</paragraph>
									<newline/>
									<template subtype="element" match="profileDefinition">
										<children>
											<paragraph paragraphtag="fieldset">
												<styles background-color="#ffffe9"/>
												<children>
													<template subtype="element" match="authorizedOrganizations">
														<children>
															<text fixtext="Organizations authorized to use the resource">
																<styles font-family="Verdana" font-size="11pt" font-weight="bold" text-decoration="underline"/>
															</text>
															<tgrid>
																<properties border="1"/>
																<styles font-family="Verdana" font-size="11pt" width="90%"/>
																<children>
																	<tgridbody-cols>
																		<children>
																			<tgridcol/>
																			<tgridcol/>
																		</children>
																	</tgridbody-cols>
																	<tgridheader-rows>
																		<children>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<children>
																							<text fixtext="Organization Id*"/>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<text fixtext="Organization name*">
																								<styles font-weight="bold"/>
																							</text>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																		</children>
																	</tgridheader-rows>
																	<tgridbody-rows>
																		<children>
																			<template subtype="type" match="Id">
																				<children>
																					<tgridrow>
																						<children>
																							<tgridcell>
																								<styles text-align="center"/>
																								<children>
																									<template subtype="attribute" match="id">
																										<children>
																											<content subtype="regular"/>
																										</children>
																										<variables/>
																									</template>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<styles text-align="center"/>
																								<children>
																									<template subtype="attribute" match="name">
																										<children>
																											<content subtype="regular"/>
																										</children>
																										<variables/>
																									</template>
																								</children>
																							</tgridcell>
																						</children>
																					</tgridrow>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</tgridbody-rows>
																</children>
															</tgrid>
														</children>
														<variables/>
													</template>
												</children>
											</paragraph>
											<paragraph paragraphtag="fieldset">
												<styles background-color="#ffffe9"/>
												<children>
													<template subtype="element" match="supportedTerminologies">
														<children>
															<text fixtext="Terminologies supported by the resource">
																<styles font-family="Verdana" font-size="11pt" font-weight="bold" text-decoration="underline"/>
															</text>
															<tgrid>
																<properties border="1"/>
																<children>
																	<tgridbody-cols>
																		<children>
																			<tgridcol/>
																		</children>
																	</tgridbody-cols>
																	<tgridheader-rows>
																		<children>
																			<tgridrow>
																				<styles font-weight="normal"/>
																				<children>
																					<tgridcell>
																						<children>
																							<text fixtext="Terminology">
																								<styles font-family="Verdana" font-size="11pt"/>
																							</text>
																							<text fixtext="*"/>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																		</children>
																	</tgridheader-rows>
																	<tgridbody-rows>
																		<children>
																			<template subtype="element" match="supportedTerminology">
																				<children>
																					<tgridrow>
																						<children>
																							<tgridcell>
																								<children>
																									<template subtype="attribute" match="id">
																										<children>
																											<combobox>
																												<children>
																													<content subtype="regular"/>
																												</children>
																												<selectoption description="ICD9" value="2.16.840.1.113883.6.103"/>
																												<selectoption description="ICD10" value="2.16.840.1.113883.6.3"/>
																												<selectoption description="SNOMED CT" value="2.16.840.1.113883.6.96"/>
																												<selectoption description="RxNorm" value="2.16.840.1.113883.6.88"/>
																												<selectoption description="MeSH" value="2.16.840.1.113883.6.177"/>
																												<selectoption description="NDC" value="2.16.840.1.113883.6.69"/>
																												<selectoption description="LOINC" value="2.16.840.1.113883.6.1"/>
																											</combobox>
																										</children>
																										<variables/>
																									</template>
																								</children>
																							</tgridcell>
																						</children>
																					</tgridrow>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</tgridbody-rows>
																</children>
															</tgrid>
														</children>
														<variables/>
													</template>
												</children>
											</paragraph>
											<paragraph paragraphtag="fieldset">
												<styles background-color="#ffffe9"/>
												<children>
													<text fixtext=" "/>
													<text fixtext="Compliant with HL7 Infobutton URL Standard">
														<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
													</text>
													<text fixtext="*  "/>
													<template subtype="attribute" match="hl7URLCompliant">
														<children>
															<radiobutton checkedvalue="true" checkedvalue1="1">
																<children>
																	<content subtype="regular"/>
																</children>
															</radiobutton>
															<text fixtext="Yes">
																<styles font-family="Verdana" font-size="11pt" font-weight="normal"/>
															</text>
														</children>
														<variables/>
													</template>
													<text fixtext="   "/>
													<template subtype="attribute" match="hl7URLCompliant">
														<children>
															<radiobutton checkedvalue="false" checkedvalue1="0">
																<children>
																	<content subtype="regular"/>
																</children>
															</radiobutton>
															<text fixtext="No">
																<styles font-family="Verdana" font-size="11pt" font-weight="normal"/>
															</text>
														</children>
														<variables/>
													</template>
												</children>
											</paragraph>
											<paragraph paragraphtag="fieldset">
												<styles background-color="#ffffe9"/>
												<children>
													<text fixtext=" Compliant with HL7 Infobutton SOA Standard*">
														<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
													</text>
													<text fixtext=" "/>
													<template subtype="attribute" match="hl7KnowledgeResponseCompliant">
														<children>
															<radiobutton checkedvalue="true" checkedvalue1="1">
																<children>
																	<content subtype="regular"/>
																</children>
															</radiobutton>
															<text fixtext="Yes">
																<styles font-family="Verdana" font-size="11pt" font-weight="normal"/>
															</text>
														</children>
														<variables/>
													</template>
													<text fixtext="   "/>
													<template subtype="attribute" match="hl7KnowledgeResponseCompliant">
														<children>
															<radiobutton checkedvalue="false" checkedvalue1="0">
																<children>
																	<content subtype="regular"/>
																</children>
															</radiobutton>
															<text fixtext="No ">
																<styles font-family="Verdana" font-size="11pt" font-weight="normal"/>
															</text>
														</children>
														<variables/>
													</template>
												</children>
											</paragraph>
											<condition>
												<children>
													<conditionbranch xpath="@hl7URLCompliant=false()">
														<children>
															<paragraph paragraphtag="fieldset">
																<styles background-color="#ffffe9"/>
																<children>
																	<text fixtext="URL style (required for non-HL7 compliant resources)">
																		<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																	</text>
																	<text fixtext="*">
																		<styles font-family="Verdana" font-size="11pt"/>
																	</text>
																	<template subtype="attribute" match="urlStyle">
																		<children>
																			<combobox>
																				<children>
																					<content subtype="regular"/>
																				</children>
																				<selectoption description="CLEAN" value="CLEAN"/>
																				<selectoption description="DIRTY" value="DIRTY"/>
																			</combobox>
																		</children>
																		<variables/>
																	</template>
																</children>
															</paragraph>
														</children>
													</conditionbranch>
												</children>
											</condition>
											<newline/>
											<paragraph paragraphtag="p">
												<styles text-align="center"/>
												<children>
													<text fixtext="Context(s) in which the resource is relevant">
														<styles font-family="Verdana" font-size="14pt" font-weight="bold" text-decoration="underline"/>
													</text>
												</children>
											</paragraph>
											<template subtype="element" match="contexts">
												<children>
													<template subtype="element" match="context">
														<children>
															<text fixtext="Context definition (">
																<styles font-family="Verdana" font-size="12pt" font-weight="bold" text-decoration="underline"/>
															</text>
															<autocalc xpath="position()">
																<styles color="blue" font-family="Verdana" font-size="12pt" font-weight="bold" text-decoration="underline"/>
															</autocalc>
															<text fixtext=" of ">
																<styles font-family="Verdana" font-size="11pt" font-weight="bold" text-decoration="underline"/>
															</text>
															<autocalc xpath="count( $XML/knowledgeResourceProfile/profileDefinition/contexts/context )">
																<styles color="blue" font-family="Verdana" font-size="12pt" font-weight="bold" text-decoration="underline"/>
															</autocalc>
															<text fixtext=")">
																<styles font-family="Verdana" font-size="11pt" font-weight="bold" text-decoration="underline"/>
															</text>
															<newline/>
															<newline/>
															<tgrid>
																<properties border="1" width="100%"/>
																<styles background-color="#ffffc3" font-family="Verdana" font-size="11pt" width="80%"/>
																<children>
																	<tgridbody-cols>
																		<children>
																			<tgridcol>
																				<styles width="1.48in"/>
																			</tgridcol>
																			<tgridcol/>
																		</children>
																	</tgridbody-cols>
																	<tgridbody-rows>
																		<children>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<children>
																							<text fixtext="ID">
																								<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="attribute" match="id">
																								<children>
																									<autocalc xpath="$contextNumber">
																										<styles font-style="italic"/>
																									</autocalc>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<children>
																							<text fixtext="Name">
																								<styles font-family="Verdana" font-size="11pt" font-weight="normal"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="attribute" match="name">
																								<children>
																									<content subtype="regular">
																										<styles font-family="Verdana" font-size="11pt"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<children>
																							<text fixtext="Description">
																								<styles font-family="Verdana" font-size="11pt" font-weight="normal"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="contextDescription">
																								<children>
																									<content subtype="regular">
																										<styles font-family="Verdana" font-size="11pt"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<children>
																							<text fixtext="Resource base URL*">
																								<styles font-weight="bold"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="knowledgeRequestService">
																								<children>
																									<template subtype="element" match="knowledgeRequestServiceLocation">
																										<children>
																											<template subtype="attribute" match="url">
																												<children>
																													<content subtype="regular"/>
																												</children>
																												<variables/>
																											</template>
																										</children>
																										<variables/>
																									</template>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<children>
																							<text fixtext="URL static parameters">
																								<styles font-weight="normal"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="knowledgeRequestService">
																								<children>
																									<template subtype="element" match="attributes">
																										<children>
																											<tgrid>
																												<properties border="1"/>
																												<children>
																													<tgridbody-cols>
																														<children>
																															<tgridcol/>
																															<tgridcol/>
																														</children>
																													</tgridbody-cols>
																													<tgridheader-rows>
																														<children>
																															<tgridrow>
																																<children>
																																	<tgridcell>
																																		<children>
																																			<text fixtext="name*"/>
																																		</children>
																																	</tgridcell>
																																	<tgridcell>
																																		<children>
																																			<text fixtext="value*"/>
																																		</children>
																																	</tgridcell>
																																</children>
																															</tgridrow>
																														</children>
																													</tgridheader-rows>
																													<tgridbody-rows>
																														<children>
																															<template subtype="element" match="attribute">
																																<children>
																																	<tgridrow>
																																		<children>
																																			<tgridcell>
																																				<children>
																																					<template subtype="attribute" match="name">
																																						<children>
																																							<content subtype="regular"/>
																																						</children>
																																						<variables/>
																																					</template>
																																				</children>
																																			</tgridcell>
																																			<tgridcell>
																																				<children>
																																					<template subtype="attribute" match="value">
																																						<children>
																																							<content subtype="regular"/>
																																						</children>
																																						<variables/>
																																					</template>
																																				</children>
																																			</tgridcell>
																																		</children>
																																	</tgridrow>
																																</children>
																																<variables/>
																															</template>
																														</children>
																													</tgridbody-rows>
																												</children>
																											</tgrid>
																										</children>
																										<variables/>
																									</template>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																		</children>
																	</tgridbody-rows>
																</children>
															</tgrid>
															<newline/>
															<template subtype="element" match="contextDefinition">
																<children>
																	<paragraph paragraphtag="fieldset">
																		<styles background-color="#acc3e7"/>
																		<children>
																			<text fixtext="Gender">
																				<styles font-family="Verdana" font-size="11pt" text-decoration="underline"/>
																			</text>
																			<text fixtext=" ">
																				<styles font-family="Verdana" font-size="11pt"/>
																			</text>
																			<template subtype="element" match="patientGender">
																				<children>
																					<calltemplate subtype="named" match="SearchingMatching">
																						<parameters/>
																					</calltemplate>
																					<condition>
																						<children>
																							<conditionbranch xpath="@match=true()">
																								<children>
																									<paragraph paragraphtag="fieldset">
																										<children>
																											<template subtype="element" match="matchingDomain">
																												<editorproperties adding="no"/>
																												<children>
																													<template subtype="element" match="enumeration">
																														<editorproperties adding="mandatory"/>
																														<children>
																															<text fixtext="Matching domain enumeration">
																																<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																															</text>
																															<tgrid>
																																<properties border="1"/>
																																<children>
																																	<tgridbody-cols>
																																		<children>
																																			<tgridcol/>
																																			<tgridcol/>
																																		</children>
																																	</tgridbody-cols>
																																	<tgridheader-rows>
																																		<children>
																																			<tgridrow>
																																				<children>
																																					<tgridcell>
																																						<children>
																																							<text fixtext=" [Code* / Code System*] - Press TAB to add more">
																																								<styles font-family="Verdana" font-size="11pt"/>
																																							</text>
																																						</children>
																																					</tgridcell>
																																					<tgridcell joinleft="1"/>
																																				</children>
																																			</tgridrow>
																																		</children>
																																	</tgridheader-rows>
																																	<tgridbody-rows>
																																		<children>
																																			<template subtype="element" match="code">
																																				<editorproperties adding="mandatory"/>
																																				<children>
																																					<tgridrow>
																																						<children>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="code">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="Male" value="M"/>
																																												<selectoption description="Female" value="F"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="codeSystem">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="HL7 Administrative Gender" value="2.16.840.1.113883.5.1"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																						</children>
																																					</tgridrow>
																																				</children>
																																				<variables/>
																																			</template>
																																		</children>
																																	</tgridbody-rows>
																																</children>
																															</tgrid>
																														</children>
																														<variables/>
																													</template>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</paragraph>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</paragraph>
																	<newline/>
																	<paragraph paragraphtag="fieldset">
																		<styles background-color="#5e99cf"/>
																		<children>
																			<text fixtext="Age group">
																				<styles font-family="Verdana" font-size="11pt" text-decoration="underline"/>
																			</text>
																			<text fixtext=" ">
																				<styles font-family="Verdana" font-size="11pt"/>
																			</text>
																			<template subtype="element" match="patientAgeGroup">
																				<children>
																					<calltemplate subtype="named" match="SearchingMatching">
																						<parameters/>
																					</calltemplate>
																					<condition>
																						<children>
																							<conditionbranch xpath="@match=true()">
																								<children>
																									<paragraph paragraphtag="fieldset">
																										<children>
																											<template subtype="element" match="matchingDomain">
																												<children>
																													<template subtype="element" match="enumeration">
																														<children>
																															<text fixtext="Matching domain enumeration">
																																<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																															</text>
																															<tgrid>
																																<properties border="1"/>
																																<children>
																																	<tgridbody-cols>
																																		<children>
																																			<tgridcol/>
																																			<tgridcol/>
																																		</children>
																																	</tgridbody-cols>
																																	<tgridheader-rows>
																																		<children>
																																			<tgridrow>
																																				<children>
																																					<tgridcell>
																																						<children>
																																							<text fixtext=" [Code* / Code System*] - Press TAB to add more">
																																								<styles font-family="Verdana" font-size="11pt"/>
																																							</text>
																																						</children>
																																					</tgridcell>
																																					<tgridcell joinleft="1"/>
																																				</children>
																																			</tgridrow>
																																		</children>
																																	</tgridheader-rows>
																																	<tgridbody-rows>
																																		<children>
																																			<template subtype="element" match="code">
																																				<children>
																																					<tgridrow>
																																						<children>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="code">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="adolescent; 13-18 years" value="D000293"/>
																																												<selectoption description="adult; 19-44 years" value="D000328"/>
																																												<selectoption description="aged; 56-79 years" value="D000368"/>
																																												<selectoption description="aged; 80 and older" value="D000369"/>
																																												<selectoption description="middle aged; 45-64 years" value="D008875"/>
																																												<selectoption description="young adult; 19-24 years" value="D055815"/>
																																												<selectoption description="child; 6 to 12 years" value="D002648"/>
																																												<selectoption description="child, preschool; 2 to 5 years" value="D002675"/>
																																												<selectoption description="Infant; 1 to 23 months" value="D007223"/>
																																												<selectoption description="infant, newborn; birth to 1 month" value="D007231"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="codeSystem">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="MeSH" value="2.16.840.1.113883.6.177"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																						</children>
																																					</tgridrow>
																																				</children>
																																				<variables/>
																																			</template>
																																		</children>
																																	</tgridbody-rows>
																																</children>
																															</tgrid>
																														</children>
																														<variables/>
																													</template>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</paragraph>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</paragraph>
																	<newline/>
																	<paragraph paragraphtag="fieldset">
																		<styles background-color="#acc3e7"/>
																		<children>
																			<text fixtext="Task">
																				<styles font-family="Verdana" font-size="11pt" font-weight="bold" text-decoration="underline"/>
																			</text>
																			<text fixtext="* "/>
																			<template subtype="element" match="task">
																				<children>
																					<calltemplate subtype="named" match="SearchingMatching">
																						<parameters/>
																					</calltemplate>
																					<condition>
																						<children>
																							<conditionbranch xpath="@match=true()">
																								<children>
																									<paragraph paragraphtag="fieldset">
																										<children>
																											<template subtype="element" match="matchingDomain">
																												<children>
																													<template subtype="element" match="enumeration">
																														<children>
																															<text fixtext="Matching domain enumeration">
																																<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																															</text>
																															<tgrid>
																																<properties border="1"/>
																																<children>
																																	<tgridbody-cols>
																																		<children>
																																			<tgridcol/>
																																			<tgridcol/>
																																		</children>
																																	</tgridbody-cols>
																																	<tgridheader-rows>
																																		<children>
																																			<tgridrow>
																																				<children>
																																					<tgridcell>
																																						<children>
																																							<text fixtext=" [Code* / Code System*] - Press TAB to add more">
																																								<styles font-family="Verdana" font-size="11pt"/>
																																							</text>
																																						</children>
																																					</tgridcell>
																																					<tgridcell joinleft="1"/>
																																				</children>
																																			</tgridrow>
																																		</children>
																																	</tgridheader-rows>
																																	<tgridbody-rows>
																																		<children>
																																			<template subtype="element" match="code">
																																				<children>
																																					<tgridrow>
																																						<children>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="code">
																																										<children>
																																											<combobox sortinauthentic="1">
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="Patient documentation" value="PATDOC"/>
																																												<selectoption description="Patient information review" value="PATINFO"/>
																																												<selectoption description="Clinical note entry" value="CLINNOTEE"/>
																																												<selectoption description="Clinical note review" value="CLINNOTEREV"/>
																																												<selectoption description="Diagnosis list entry" value="DIAGLISTE"/>
																																												<selectoption description="Diagnosis list review" value="DIAGLISTREV"/>
																																												<selectoption description="Discharge summary entry" value="DISCHSUME"/>
																																												<selectoption description="Discharge summary review" value="DISCHSUMREV"/>
																																												<selectoption description="Pathology report entry" value="PATREPE"/>
																																												<selectoption description="Pathology report review" value="PATREPREV"/>
																																												<selectoption description="Problem list entry" value="PROBLISTE"/>
																																												<selectoption description="Problem list review" value="PROBLISTREV"/>
																																												<selectoption description="Radiology report entry" value="RADREPE"/>
																																												<selectoption description="Radiology report review" value="RADREPREV"/>
																																												<selectoption description="Order entry" value="OE"/>
																																												<selectoption description="Orders review" value="OREV"/>
																																												<selectoption description="Medication list review" value="MLREV"/>
																																												<selectoption description="Medication order entry" value="MEDOE"/>
																																												<selectoption description="Medication administration record work list review" value="MARWLREV"/>
																																												<selectoption description="Lab order entry" value="LABOE"/>
																																												<selectoption description="Laboratory results review" value="LABRREV"/>
																																												<selectoption description="Microbiology results review" value="MICRORREV"/>
																																												<selectoption description="Microbiology organisms results review" value="MICROORGRREV"/>
																																												<selectoption description="Microbiology sensitivity test results review" value="MICROSENSRREV"/>
																																												<selectoption description="Risk assessment instrument" value="RISKASSESS"/>
																																												<selectoption description="Falls risk assessment instrument" value="FALLRISK"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="codeSystem">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="HL7" value="2.16.840.1.113883.5.4"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																						</children>
																																					</tgridrow>
																																				</children>
																																				<variables/>
																																			</template>
																																		</children>
																																	</tgridbody-rows>
																																</children>
																															</tgrid>
																														</children>
																														<variables/>
																													</template>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</paragraph>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</paragraph>
																	<newline/>
																	<paragraph paragraphtag="fieldset">
																		<styles background-color="#5e99cf"/>
																		<children>
																			<text fixtext="Service delivery location">
																				<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																			</text>
																			<text fixtext=" ">
																				<styles font-family="Verdana" font-size="11pt"/>
																			</text>
																			<tgrid>
																				<properties border="1"/>
																				<styles width="80%"/>
																				<children>
																					<tgridbody-cols>
																						<children>
																							<tgridcol/>
																							<tgridcol/>
																						</children>
																					</tgridbody-cols>
																					<tgridheader-rows>
																						<children>
																							<tgridrow>
																								<children>
																									<tgridcell>
																										<children>
																											<text fixtext="ID"/>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<text fixtext="Name"/>
																										</children>
																									</tgridcell>
																								</children>
																							</tgridrow>
																						</children>
																					</tgridheader-rows>
																					<tgridbody-rows>
																						<children>
																							<template subtype="element" match="serviceDeliveryLocation">
																								<editorproperties adding="all"/>
																								<children>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<children>
																													<template subtype="attribute" match="id">
																														<children>
																															<content subtype="regular">
																																<styles font-family="Arial"/>
																															</content>
																														</children>
																														<variables/>
																													</template>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<children>
																													<template subtype="attribute" match="name">
																														<children>
																															<content subtype="regular">
																																<styles font-family="Arial"/>
																															</content>
																														</children>
																														<variables/>
																													</template>
																												</children>
																											</tgridcell>
																										</children>
																									</tgridrow>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridbody-rows>
																				</children>
																			</tgrid>
																		</children>
																	</paragraph>
																	<newline/>
																	<paragraph paragraphtag="fieldset">
																		<styles background-color="#acc3e7"/>
																		<children>
																			<text fixtext="Encounter type">
																				<styles font-family="Verdana" font-size="11pt" text-decoration="underline"/>
																			</text>
																			<text fixtext=" ">
																				<styles font-family="Verdana" font-size="11pt"/>
																			</text>
																			<template subtype="element" match="encounterType">
																				<children>
																					<calltemplate subtype="named" match="SearchingMatching">
																						<parameters/>
																					</calltemplate>
																					<condition>
																						<children>
																							<conditionbranch xpath="@match=true()">
																								<children>
																									<paragraph paragraphtag="fieldset">
																										<children>
																											<template subtype="element" match="matchingDomain">
																												<children>
																													<template subtype="element" match="enumeration">
																														<children>
																															<text fixtext="Matching domain enumeration">
																																<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																															</text>
																															<tgrid>
																																<properties border="1"/>
																																<children>
																																	<tgridbody-cols>
																																		<children>
																																			<tgridcol/>
																																			<tgridcol/>
																																		</children>
																																	</tgridbody-cols>
																																	<tgridheader-rows>
																																		<children>
																																			<tgridrow>
																																				<children>
																																					<tgridcell>
																																						<children>
																																							<text fixtext=" [Code* / Code System*] - Press TAB to add more">
																																								<styles font-family="Verdana" font-size="11pt"/>
																																							</text>
																																						</children>
																																					</tgridcell>
																																					<tgridcell joinleft="1"/>
																																				</children>
																																			</tgridrow>
																																		</children>
																																	</tgridheader-rows>
																																	<tgridbody-rows>
																																		<children>
																																			<template subtype="element" match="code">
																																				<children>
																																					<tgridrow>
																																						<children>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="code">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="Ambulatory" value="AMB"/>
																																												<selectoption description="Emergency" value="EMER"/>
																																												<selectoption description="Field" value="FLD"/>
																																												<selectoption description="Home health" value="HH"/>
																																												<selectoption description="Inpatient" value="IMP"/>
																																												<selectoption description="Acute inpatient" value="ACUTE"/>
																																												<selectoption description="Non-acute inpatient" value="NONAC"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="codeSystem">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="HL7 ActCode" value="2.16.840.1.113883.5.4"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																						</children>
																																					</tgridrow>
																																				</children>
																																				<variables/>
																																			</template>
																																		</children>
																																	</tgridbody-rows>
																																</children>
																															</tgrid>
																														</children>
																														<variables/>
																													</template>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</paragraph>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</paragraph>
																	<newline/>
																	<paragraph paragraphtag="fieldset">
																		<styles background-color="#5e99cf"/>
																		<children>
																			<text fixtext="User language">
																				<styles font-family="Verdana" font-size="11pt" text-decoration="underline"/>
																			</text>
																			<text fixtext=" ">
																				<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																			</text>
																			<template subtype="element" match="performerLanguage">
																				<children>
																					<calltemplate subtype="named" match="SearchingMatching">
																						<parameters/>
																					</calltemplate>
																					<condition>
																						<children>
																							<conditionbranch xpath="@match=true()">
																								<children>
																									<paragraph paragraphtag="fieldset">
																										<children>
																											<template subtype="element" match="matchingDomain">
																												<children>
																													<template subtype="element" match="enumeration">
																														<children>
																															<text fixtext="Matching domain enumeration">
																																<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																															</text>
																															<tgrid>
																																<properties border="1"/>
																																<children>
																																	<tgridbody-cols>
																																		<children>
																																			<tgridcol/>
																																			<tgridcol/>
																																		</children>
																																	</tgridbody-cols>
																																	<tgridheader-rows>
																																		<children>
																																			<tgridrow>
																																				<children>
																																					<tgridcell>
																																						<children>
																																							<text fixtext=" [Code* / Code System*] - Press TAB to add more">
																																								<styles font-family="Verdana" font-size="11pt"/>
																																							</text>
																																						</children>
																																					</tgridcell>
																																					<tgridcell joinleft="1"/>
																																				</children>
																																			</tgridrow>
																																		</children>
																																	</tgridheader-rows>
																																	<tgridbody-rows>
																																		<children>
																																			<template subtype="element" match="code">
																																				<children>
																																					<tgridrow>
																																						<children>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="code">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="English" value="en"/>
																																												<selectoption description="Spanish" value="sp"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="codeSystem">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="Tags for the identification of languages (ietf3066)" value="2.16.840.1.113883.6.121"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																						</children>
																																					</tgridrow>
																																				</children>
																																				<variables/>
																																			</template>
																																		</children>
																																	</tgridbody-rows>
																																</children>
																															</tgrid>
																														</children>
																														<variables/>
																													</template>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</paragraph>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</paragraph>
																	<newline/>
																	<paragraph paragraphtag="fieldset">
																		<styles background-color="#acc3e7"/>
																		<children>
																			<text fixtext="User discipline">
																				<styles font-family="Verdana" font-size="11pt" text-decoration="underline"/>
																			</text>
																			<text fixtext=" ">
																				<styles font-family="Verdana" font-size="11pt"/>
																			</text>
																			<template subtype="element" match="performerDiscipline">
																				<children>
																					<calltemplate subtype="named" match="SearchingMatching">
																						<parameters/>
																					</calltemplate>
																					<condition>
																						<children>
																							<conditionbranch xpath="@match=true()">
																								<children>
																									<paragraph paragraphtag="fieldset">
																										<children>
																											<template subtype="element" match="matchingDomain">
																												<children>
																													<template subtype="element" match="enumeration">
																														<children>
																															<text fixtext="Matching domain enumeration">
																																<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																															</text>
																															<tgrid>
																																<properties border="1"/>
																																<children>
																																	<tgridbody-cols>
																																		<children>
																																			<tgridcol/>
																																			<tgridcol/>
																																		</children>
																																	</tgridbody-cols>
																																	<tgridheader-rows>
																																		<children>
																																			<tgridrow>
																																				<children>
																																					<tgridcell>
																																						<children>
																																							<text fixtext=" [Code* / Code System*] - Press TAB to add more">
																																								<styles font-family="Verdana" font-size="11pt"/>
																																							</text>
																																						</children>
																																					</tgridcell>
																																					<tgridcell joinleft="1"/>
																																				</children>
																																			</tgridrow>
																																		</children>
																																	</tgridheader-rows>
																																	<tgridbody-rows>
																																		<children>
																																			<template subtype="element" match="code">
																																				<children>
																																					<tgridrow>
																																						<children>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="code">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="Physician" value="200000000X"/>
																																												<selectoption description="Registered Nurse" value="163W00000X"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="codeSystem">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="NUCC Health Care provider taxonomy" value="2.16.840.1.113883.6.101"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																						</children>
																																					</tgridrow>
																																				</children>
																																				<variables/>
																																			</template>
																																		</children>
																																	</tgridbody-rows>
																																</children>
																															</tgrid>
																														</children>
																														<variables/>
																													</template>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</paragraph>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</paragraph>
																	<newline/>
																	<paragraph paragraphtag="fieldset">
																		<styles background-color="#5e99cf"/>
																		<children>
																			<text fixtext="User type ">
																				<styles font-family="Verdana" font-size="11pt" text-decoration="underline"/>
																			</text>
																			<template subtype="element" match="performerKnowledgeUserType">
																				<children>
																					<calltemplate subtype="named" match="SearchingMatching">
																						<parameters/>
																					</calltemplate>
																					<condition>
																						<children>
																							<conditionbranch xpath="@match=true()">
																								<children>
																									<paragraph paragraphtag="fieldset">
																										<children>
																											<template subtype="element" match="matchingDomain">
																												<children>
																													<template subtype="element" match="enumeration">
																														<children>
																															<text fixtext="Matching domain enumeration">
																																<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																															</text>
																															<tgrid>
																																<properties border="1"/>
																																<children>
																																	<tgridbody-cols>
																																		<children>
																																			<tgridcol/>
																																			<tgridcol/>
																																		</children>
																																	</tgridbody-cols>
																																	<tgridheader-rows>
																																		<children>
																																			<tgridrow>
																																				<children>
																																					<tgridcell>
																																						<children>
																																							<text fixtext=" [Code* / Code System*] - Press TAB to add more">
																																								<styles font-family="Verdana" font-size="11pt"/>
																																							</text>
																																						</children>
																																					</tgridcell>
																																					<tgridcell joinleft="1"/>
																																				</children>
																																			</tgridrow>
																																		</children>
																																	</tgridheader-rows>
																																	<tgridbody-rows>
																																		<children>
																																			<template subtype="element" match="code">
																																				<children>
																																					<tgridrow>
																																						<children>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="code">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="Healthcare provider" value="PROV"/>
																																												<selectoption description="Patient" value="PAT"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="codeSystem">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="HL7 RoleClass" value="2.16.840.1.113883.5.110"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																						</children>
																																					</tgridrow>
																																				</children>
																																				<variables/>
																																			</template>
																																		</children>
																																	</tgridbody-rows>
																																</children>
																															</tgrid>
																														</children>
																														<variables/>
																													</template>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</paragraph>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</paragraph>
																	<newline/>
																	<paragraph paragraphtag="fieldset">
																		<styles background-color="#acc3e7"/>
																		<children>
																			<text fixtext="Information recipient language">
																				<styles font-family="Verdana" font-size="11pt" text-decoration="underline"/>
																			</text>
																			<text fixtext=" ">
																				<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																			</text>
																			<template subtype="element" match="informationRecipientLanguage">
																				<children>
																					<calltemplate subtype="named" match="SearchingMatching">
																						<parameters/>
																					</calltemplate>
																					<condition>
																						<children>
																							<conditionbranch xpath="@match=true()">
																								<children>
																									<paragraph paragraphtag="fieldset">
																										<children>
																											<template subtype="element" match="matchingDomain">
																												<children>
																													<template subtype="element" match="enumeration">
																														<children>
																															<text fixtext="Matching domain enumeration">
																																<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																															</text>
																															<tgrid>
																																<properties border="1"/>
																																<children>
																																	<tgridbody-cols>
																																		<children>
																																			<tgridcol/>
																																			<tgridcol/>
																																		</children>
																																	</tgridbody-cols>
																																	<tgridheader-rows>
																																		<children>
																																			<tgridrow>
																																				<children>
																																					<tgridcell>
																																						<children>
																																							<text fixtext=" [Code* / Code System*] - Press TAB to add more">
																																								<styles font-family="Verdana" font-size="11pt"/>
																																							</text>
																																						</children>
																																					</tgridcell>
																																					<tgridcell joinleft="1"/>
																																				</children>
																																			</tgridrow>
																																		</children>
																																	</tgridheader-rows>
																																	<tgridbody-rows>
																																		<children>
																																			<template subtype="element" match="code">
																																				<children>
																																					<tgridrow>
																																						<children>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="code">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="English" value="en"/>
																																												<selectoption description="Spanish" value="sp"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="codeSystem">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="Tags for the identification of languages (ietf3066)" value="2.16.840.1.113883.6.121"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																						</children>
																																					</tgridrow>
																																				</children>
																																				<variables/>
																																			</template>
																																		</children>
																																	</tgridbody-rows>
																																</children>
																															</tgrid>
																														</children>
																														<variables/>
																													</template>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</paragraph>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</paragraph>
																	<newline/>
																	<paragraph paragraphtag="fieldset">
																		<styles background-color="#5e99cf"/>
																		<children>
																			<text fixtext="Information recipient discipline">
																				<styles font-family="Verdana" font-size="11pt" text-decoration="underline"/>
																			</text>
																			<text fixtext=" ">
																				<styles font-family="Verdana" font-size="11pt"/>
																			</text>
																			<template subtype="element" match="informationRecipientDiscipline">
																				<children>
																					<calltemplate subtype="named" match="SearchingMatching">
																						<parameters/>
																					</calltemplate>
																					<condition>
																						<children>
																							<conditionbranch xpath="@match=true()">
																								<children>
																									<paragraph paragraphtag="fieldset">
																										<children>
																											<template subtype="element" match="matchingDomain">
																												<children>
																													<template subtype="element" match="enumeration">
																														<children>
																															<text fixtext="Matching domain enumeration">
																																<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																															</text>
																															<tgrid>
																																<properties border="1"/>
																																<children>
																																	<tgridbody-cols>
																																		<children>
																																			<tgridcol/>
																																			<tgridcol/>
																																		</children>
																																	</tgridbody-cols>
																																	<tgridheader-rows>
																																		<children>
																																			<tgridrow>
																																				<children>
																																					<tgridcell>
																																						<children>
																																							<text fixtext=" [Code* / Code System*] - Press TAB to add more">
																																								<styles font-family="Verdana" font-size="11pt"/>
																																							</text>
																																						</children>
																																					</tgridcell>
																																					<tgridcell joinleft="1"/>
																																				</children>
																																			</tgridrow>
																																		</children>
																																	</tgridheader-rows>
																																	<tgridbody-rows>
																																		<children>
																																			<template subtype="element" match="code">
																																				<children>
																																					<tgridrow>
																																						<children>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="code">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="Physician" value="200000000X"/>
																																												<selectoption description="Registered Nurse" value="163W00000X"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="codeSystem">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="NUCC Health Care provider taxonomy" value="2.16.840.1.113883.6.101"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																						</children>
																																					</tgridrow>
																																				</children>
																																				<variables/>
																																			</template>
																																		</children>
																																	</tgridbody-rows>
																																</children>
																															</tgrid>
																														</children>
																														<variables/>
																													</template>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</paragraph>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</paragraph>
																	<newline/>
																	<paragraph paragraphtag="fieldset">
																		<styles background-color="#acc3e7"/>
																		<children>
																			<text fixtext="Information recipient type">
																				<styles font-family="Verdana" font-size="11pt" text-decoration="underline"/>
																			</text>
																			<text fixtext=" ">
																				<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																			</text>
																			<template subtype="element" match="informationRecipientUserType">
																				<children>
																					<calltemplate subtype="named" match="SearchingMatching">
																						<parameters/>
																					</calltemplate>
																					<condition>
																						<children>
																							<conditionbranch xpath="@match=true()">
																								<children>
																									<paragraph paragraphtag="fieldset">
																										<children>
																											<template subtype="element" match="matchingDomain">
																												<children>
																													<template subtype="element" match="enumeration">
																														<children>
																															<text fixtext="Matching domain enumeration">
																																<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																															</text>
																															<tgrid>
																																<properties border="1"/>
																																<children>
																																	<tgridbody-cols>
																																		<children>
																																			<tgridcol/>
																																			<tgridcol/>
																																		</children>
																																	</tgridbody-cols>
																																	<tgridheader-rows>
																																		<children>
																																			<tgridrow>
																																				<children>
																																					<tgridcell>
																																						<children>
																																							<text fixtext=" [Code* / Code System*] - Press TAB to add more">
																																								<styles font-family="Verdana" font-size="11pt"/>
																																							</text>
																																						</children>
																																					</tgridcell>
																																					<tgridcell joinleft="1"/>
																																				</children>
																																			</tgridrow>
																																		</children>
																																	</tgridheader-rows>
																																	<tgridbody-rows>
																																		<children>
																																			<template subtype="element" match="code">
																																				<children>
																																					<tgridrow>
																																						<children>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="code">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="Healthcare provider" value="PROV"/>
																																												<selectoption description="Patient" value="PAT"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="codeSystem">
																																										<children>
																																											<combobox>
																																												<children>
																																													<content subtype="regular"/>
																																												</children>
																																												<selectoption description="HL7 RoleClass" value="2.16.840.1.113883.5.110"/>
																																											</combobox>
																																										</children>
																																										<variables/>
																																									</template>
																																								</children>
																																							</tgridcell>
																																						</children>
																																					</tgridrow>
																																				</children>
																																				<variables/>
																																			</template>
																																		</children>
																																	</tgridbody-rows>
																																</children>
																															</tgrid>
																														</children>
																														<variables/>
																													</template>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</paragraph>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</paragraph>
																	<newline/>
																	<paragraph paragraphtag="fieldset">
																		<styles background-color="#5e99cf"/>
																		<children>
																			<text fixtext="Concept of interest">
																				<styles font-family="Verdana" font-size="11pt" font-weight="bold" text-decoration="underline"/>
																			</text>
																			<text fixtext="* ">
																				<styles font-family="Verdana" font-size="11pt"/>
																			</text>
																			<template subtype="element" match="conceptOfInterest">
																				<children>
																					<calltemplate subtype="named" match="SearchingMatching">
																						<parameters/>
																					</calltemplate>
																					<newline/>
																					<condition>
																						<children>
																							<conditionbranch xpath="@match=true()">
																								<children>
																									<template subtype="element" match="matchingDomain">
																										<editorproperties adding="no"/>
																										<children>
																											<condition>
																												<children>
																													<conditionbranch xpath="count(externalValueSet) = 0">
																														<children>
																															<text fixtext="Matching domain enumeration">
																																<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																															</text>
																															<newline/>
																															<template subtype="element" match="enumeration">
																																<editorproperties adding="mandatory"/>
																																<children>
																																	<tgrid>
																																		<properties border="1"/>
																																		<children>
																																			<tgridbody-cols>
																																				<children>
																																					<tgridcol/>
																																					<tgridcol/>
																																				</children>
																																			</tgridbody-cols>
																																			<tgridheader-rows>
																																				<children>
																																					<tgridrow>
																																						<children>
																																							<tgridcell>
																																								<children>
																																									<text fixtext=" [Code* / Code System*] - Press TAB to add more">
																																										<styles font-family="Verdana" font-size="11pt"/>
																																									</text>
																																								</children>
																																							</tgridcell>
																																							<tgridcell joinleft="1"/>
																																						</children>
																																					</tgridrow>
																																				</children>
																																			</tgridheader-rows>
																																			<tgridbody-rows>
																																				<children>
																																					<template subtype="element" match="code">
																																						<editorproperties adding="mandatory"/>
																																						<children>
																																							<tgridrow>
																																								<children>
																																									<tgridcell>
																																										<children>
																																											<template subtype="attribute" match="code">
																																												<children>
																																													<content subtype="regular">
																																														<styles font-family="Verdana" font-size="11pt"/>
																																													</content>
																																												</children>
																																												<variables/>
																																											</template>
																																										</children>
																																									</tgridcell>
																																									<tgridcell>
																																										<children>
																																											<template subtype="attribute" match="codeSystem">
																																												<children>
																																													<combobox>
																																														<children>
																																															<content subtype="regular"/>
																																														</children>
																																														<selectoption description="ICD9" value="2.16.840.1.113883.6.103"/>
																																														<selectoption description="ICD10" value="2.16.840.1.113883.6.3"/>
																																														<selectoption description="SNOMED CT" value="2.16.840.1.113883.6.96"/>
																																														<selectoption description="RxNorm" value="2.16.840.1.113883.6.88"/>
																																														<selectoption description="MeSH" value="2.16.840.1.113883.6.177"/>
																																														<selectoption description="NDC" value="2.16.840.1.113883.6.69"/>
																																														<selectoption description="LOINC" value="2.16.840.1.113883.6.1"/>
																																													</combobox>
																																												</children>
																																												<variables/>
																																											</template>
																																										</children>
																																									</tgridcell>
																																								</children>
																																							</tgridrow>
																																						</children>
																																						<variables/>
																																					</template>
																																				</children>
																																			</tgridbody-rows>
																																		</children>
																																	</tgrid>
																																	<template subtype="attribute" match="includeDescendants">
																																		<children>
																																			<text fixtext="Include descendants: ">
																																				<styles font-family="Verdana" font-size="11pt"/>
																																			</text>
																																			<checkbox checkedvalue="true" checkedvalue1="1">
																																				<children>
																																					<content subtype="regular"/>
																																				</children>
																																			</checkbox>
																																		</children>
																																		<variables/>
																																	</template>
																																</children>
																																<variables/>
																															</template>
																														</children>
																													</conditionbranch>
																												</children>
																											</condition>
																											<newline/>
																											<condition>
																												<children>
																													<conditionbranch xpath="count(enumeration)=0">
																														<children>
																															<text fixtext="Matching domain external value set">
																																<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																															</text>
																															<newline/>
																															<template subtype="element" match="externalValueSet">
																																<editorproperties adding="mandatory"/>
																																<children>
																																	<template subtype="attribute" match="id">
																																		<children>
																																			<text fixtext="Value set ID*:">
																																				<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																																			</text>
																																			<text fixtext=" ">
																																				<styles font-family="Verdana" font-size="11pt"/>
																																			</text>
																																			<editfield>
																																				<children>
																																					<content subtype="regular"/>
																																				</children>
																																			</editfield>
																																		</children>
																																		<variables/>
																																	</template>
																																</children>
																																<variables/>
																															</template>
																														</children>
																													</conditionbranch>
																												</children>
																											</condition>
																										</children>
																										<variables/>
																									</template>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</paragraph>
																	<newline/>
																	<paragraph paragraphtag="fieldset">
																		<styles background-color="#acc3e7"/>
																		<children>
																			<text fixtext="Subtopics">
																				<styles font-family="Verdana" font-size="11pt" font-weight="bold" text-decoration="underline"/>
																			</text>
																			<text fixtext=" ">
																				<styles font-family="Verdana" font-size="11pt" text-decoration="underline"/>
																			</text>
																			<text fixtext="/ links">
																				<styles font-family="Verdana" font-size="11pt" font-weight="bold" text-decoration="underline"/>
																			</text>
																			<text fixtext="*">
																				<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																			</text>
																			<text fixtext=" ">
																				<styles font-family="Verdana" font-size="11pt"/>
																			</text>
																			<template subtype="element" match="subTopics">
																				<children>
																					<newline/>
																					<tgrid>
																						<properties border="1"/>
																						<children>
																							<tgridbody-cols>
																								<children>
																									<tgridcol/>
																									<tgridcol/>
																								</children>
																							</tgridbody-cols>
																							<tgridheader-rows>
																								<children>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<children>
																													<text fixtext="Link label*">
																														<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																													</text>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<children>
																													<text fixtext="Search parameter [Code / Code System]">
																														<styles font-family="Verdana" font-size="11pt" font-weight="normal"/>
																													</text>
																												</children>
																											</tgridcell>
																										</children>
																									</tgridrow>
																								</children>
																							</tgridheader-rows>
																							<tgridbody-rows>
																								<children>
																									<template subtype="element" match="subTopic">
																										<children>
																											<tgridrow>
																												<children>
																													<tgridcell>
																														<children>
																															<template subtype="attribute" match="linkName">
																																<children>
																																	<content subtype="regular">
																																		<styles font-family="Verdana" font-size="11pt"/>
																																	</content>
																																</children>
																																<variables/>
																															</template>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="searchParameter">
																																<children>
																																	<template subtype="element" match="valueSource">
																																		<children>
																																			<template subtype="element" match="searchCode">
																																				<children>
																																					<template subtype="element" match="code">
																																						<children>
																																							<template subtype="attribute" match="codeSystem">
																																								<children>
																																									<combobox>
																																										<children>
																																											<content subtype="regular"/>
																																										</children>
																																										<selectoption description="SNOMED CT" value="2.16.840.1.113883.6.96"/>
																																										<selectoption description="MeSH" value="2.16.840.1.113883.6.177"/>
																																									</combobox>
																																								</children>
																																								<variables/>
																																							</template>
																																							<text fixtext=" "/>
																																							<template subtype="attribute" match="code">
																																								<children>
																																									<condition>
																																										<children>
																																											<conditionbranch xpath="../@codeSystem=&apos;2.16.840.1.113883.6.96&apos;">
																																												<children>
																																													<combobox sortinauthentic="1">
																																														<children>
																																															<content subtype="regular"/>
																																														</children>
																																														<selectoption description="Drug interaction" value="79899007"/>
																																														<selectoption description="Differential diagnosis" value="47965005"/>
																																														<selectoption description="Drug interaction with drug" value="404204005"/>
																																														<selectoption description="Drug interaction with food" value="95907004"/>
																																														<selectoption description="Drug interaction with alcohol" value="95906008"/>
																																													</combobox>
																																												</children>
																																											</conditionbranch>
																																										</children>
																																									</condition>
																																									<condition>
																																										<children>
																																											<conditionbranch xpath="../@codeSystem=&apos;2.16.840.1.113883.6.177&apos;">
																																												<children>
																																													<combobox sortinauthentic="1">
																																														<children>
																																															<content subtype="regular"/>
																																														</children>
																																														<selectoption description="Administration &amp; dosage" value="Q000008"/>
																																														<selectoption description="Contraindications" value="Q000744"/>
																																														<selectoption description="Adverse effects" value="Q000009"/>
																																														<selectoption description="Drug interaction" value="D004347"/>
																																														<selectoption description="Classification" value="Q000145"/>
																																														<selectoption description="Etiology" value="Q000209"/>
																																														<selectoption description="Diagnosis" value="Q000175"/>
																																														<selectoption description="Therapy" value="Q000628"/>
																																														<selectoption description="Prognosis" value="D011379"/>
																																														<selectoption description="Therapeutic use" value="Q000627"/>
																																														<selectoption description="Pharmacokinetics" value="Q000493"/>
																																														<selectoption description="Pharmacology" value="Q000494"/>
																																														<selectoption description="Toxicity" value="Q000633"/>
																																														<selectoption description="Poisoning" value="Q000506"/>
																																													</combobox>
																																												</children>
																																											</conditionbranch>
																																										</children>
																																									</condition>
																																								</children>
																																								<variables/>
																																							</template>
																																						</children>
																																						<variables/>
																																					</template>
																																				</children>
																																				<variables/>
																																			</template>
																																		</children>
																																		<variables/>
																																	</template>
																																</children>
																																<variables/>
																															</template>
																														</children>
																													</tgridcell>
																												</children>
																											</tgridrow>
																										</children>
																										<variables/>
																									</template>
																								</children>
																							</tgridbody-rows>
																						</children>
																					</tgrid>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</paragraph>
																	<condition>
																		<children>
																			<conditionbranch xpath="../../../@hl7URLCompliant=false()">
																				<children>
																					<paragraph paragraphtag="fieldset">
																						<styles background-color="#acc3e7"/>
																						<children>
																							<text fixtext="Search parameter* ">
																								<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																							</text>
																							<template subtype="element" match="subTopics">
																								<children>
																									<template subtype="element" match="subTopic">
																										<children>
																											<template subtype="element" match="searchParameter">
																												<children>
																													<template subtype="element" match="syntaxOnResource">
																														<children>
																															<tgrid>
																																<properties border="1"/>
																																<children>
																																	<tgridbody-cols>
																																		<children>
																																			<tgridcol/>
																																			<tgridcol/>
																																		</children>
																																	</tgridbody-cols>
																																	<tgridbody-rows>
																																		<children>
																																			<tgridrow>
																																				<children>
																																					<tgridcell>
																																						<children>
																																							<text fixtext="Parameter value prefix">
																																								<styles font-family="Verdana" font-size="11pt"/>
																																							</text>
																																						</children>
																																					</tgridcell>
																																					<tgridcell>
																																						<styles text-align="left"/>
																																						<children>
																																							<template subtype="attribute" match="valuePrefix">
																																								<children>
																																									<content subtype="regular">
																																										<styles font-family="Verdana" font-size="11pt"/>
																																									</content>
																																								</children>
																																								<variables/>
																																							</template>
																																						</children>
																																					</tgridcell>
																																				</children>
																																			</tgridrow>
																																			<tgridrow>
																																				<children>
																																					<tgridcell>
																																						<children>
																																							<text fixtext="Parameter name*">
																																								<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																																							</text>
																																							<text fixtext=" ">
																																								<styles font-family="Verdana" font-size="11pt"/>
																																							</text>
																																						</children>
																																					</tgridcell>
																																					<tgridcell>
																																						<styles text-align="left"/>
																																						<children>
																																							<template subtype="attribute" match="nonHl7CompliantName">
																																								<children>
																																									<content subtype="regular">
																																										<styles font-family="Verdana" font-size="11pt"/>
																																									</content>
																																								</children>
																																								<variables/>
																																							</template>
																																						</children>
																																					</tgridcell>
																																				</children>
																																			</tgridrow>
																																			<tgridrow>
																																				<children>
																																					<tgridcell>
																																						<children>
																																							<text fixtext="Parameter value suffix">
																																								<styles font-family="Verdana" font-size="11pt"/>
																																							</text>
																																						</children>
																																					</tgridcell>
																																					<tgridcell>
																																						<styles text-align="left"/>
																																						<children>
																																							<template subtype="attribute" match="valueSuffix">
																																								<children>
																																									<content subtype="regular">
																																										<styles font-family="Verdana" font-size="11pt"/>
																																									</content>
																																								</children>
																																								<variables/>
																																							</template>
																																						</children>
																																					</tgridcell>
																																				</children>
																																			</tgridrow>
																																		</children>
																																	</tgridbody-rows>
																																</children>
																															</tgrid>
																														</children>
																														<variables/>
																													</template>
																												</children>
																												<variables/>
																											</template>
																										</children>
																										<variables/>
																									</template>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</paragraph>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																</children>
																<variables/>
															</template>
															<newline/>
															<line/>
														</children>
														<variables>
															<variable name="contextNumber" value="position()" valuetype="xs:integer"/>
														</variables>
													</template>
												</children>
												<variables/>
											</template>
										</children>
										<variables/>
									</template>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts>
		<children>
			<globaltemplate subtype="type" match="Id" schema-tree-path="element(*,Id)">
				<children>
					<tgrid>
						<properties border="1" width="90%"/>
						<styles font-family="Verdana" font-size="11pt"/>
						<children>
							<tgridbody-cols>
								<children>
									<tgridcol>
										<styles width="3.69in"/>
									</tgridcol>
									<tgridcol>
										<styles width="5.86in"/>
									</tgridcol>
								</children>
							</tgridbody-cols>
							<tgridheader-rows>
								<children>
									<tgridrow>
										<children>
											<tgridcell>
												<children>
													<text fixtext="ID"/>
												</children>
											</tgridcell>
											<tgridcell>
												<children>
													<text fixtext="Name"/>
												</children>
											</tgridcell>
										</children>
									</tgridrow>
								</children>
							</tgridheader-rows>
							<tgridbody-rows>
								<children>
									<template subtype="type" match="Id">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<children>
															<template subtype="attribute" match="id">
																<children>
																	<content subtype="regular"/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="attribute" match="name">
																<children>
																	<content subtype="regular"/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
										</children>
										<variables/>
									</template>
								</children>
							</tgridbody-rows>
						</children>
					</tgrid>
				</children>
			</globaltemplate>
		</children>
	</globalparts>
	<designfragments>
		<children>
			<globaltemplate subtype="named" match="SearchingMatching">
				<parameters/>
				<children>
					<paragraph paragraphtag="fieldset">
						<children>
							<tgrid>
								<children>
									<tgridbody-cols>
										<children>
											<tgridcol>
												<properties width="20%"/>
												<styles width="3.23in"/>
											</tgridcol>
											<tgridcol>
												<properties width="20%"/>
											</tgridcol>
											<tgridcol>
												<properties width="60%"/>
											</tgridcol>
										</children>
									</tgridbody-cols>
									<tgridbody-rows>
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<children>
															<text fixtext=" ">
																<styles font-family="Verdana" font-size="11pt"/>
															</text>
															<text fixtext="Use for searching*">
																<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
															</text>
															<newline/>
															<template subtype="attribute" match="search">
																<children>
																	<radiobutton checkedvalue="true" checkedvalue1="1">
																		<children>
																			<content subtype="regular"/>
																		</children>
																	</radiobutton>
																	<text fixtext="Yes">
																		<styles font-family="Verdana" font-size="11pt" font-weight="normal"/>
																	</text>
																</children>
																<variables/>
															</template>
															<text fixtext="    "/>
															<template subtype="attribute" match="search">
																<children>
																	<radiobutton checkedvalue="false" checkedvalue1="0">
																		<children>
																			<content subtype="regular"/>
																		</children>
																	</radiobutton>
																	<text fixtext="No">
																		<styles font-family="Verdana" font-size="11pt" font-weight="normal"/>
																	</text>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<text fixtext=" ">
																<styles font-family="Verdana" font-size="11pt"/>
															</text>
															<text fixtext="Use for matching*">
																<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
															</text>
															<newline/>
															<template subtype="attribute" match="match">
																<children>
																	<radiobutton checkedvalue="true" checkedvalue1="1">
																		<children>
																			<content subtype="regular"/>
																		</children>
																	</radiobutton>
																	<text fixtext="Yes">
																		<styles font-family="Verdana" font-size="11pt" font-weight="normal"/>
																	</text>
																</children>
																<variables/>
															</template>
															<text fixtext="    "/>
															<template subtype="attribute" match="match">
																<children>
																	<radiobutton checkedvalue="false" checkedvalue1="0">
																		<children>
																			<content subtype="regular"/>
																		</children>
																	</radiobutton>
																	<text fixtext="No">
																		<styles font-family="Verdana" font-size="11pt" font-weight="normal"/>
																	</text>
																</children>
																<variables/>
															</template>
															<newline/>
														</children>
													</tgridcell>
													<tgridcell/>
												</children>
											</tgridrow>
										</children>
									</tgridbody-rows>
								</children>
							</tgrid>
						</children>
					</paragraph>
					<condition>
						<children>
							<conditionbranch xpath="@search=true() and ../../../../@hl7URLCompliant=false()">
								<children>
									<paragraph paragraphtag="fieldset">
										<children>
											<text fixtext="Search parameter* ">
												<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
											</text>
											<template subtype="element" match="searchParameter">
												<children>
													<newline/>
													<tgrid>
														<properties border="1"/>
														<children>
															<tgridbody-cols>
																<children>
																	<tgridcol/>
																	<tgridcol/>
																</children>
															</tgridbody-cols>
															<tgridheader-rows>
																<children>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<text fixtext="Parameter value source*">
																						<styles font-family="Verdana" font-size="11pt"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<styles text-align="left"/>
																				<children>
																					<template subtype="attribute" match="source">
																						<children>
																							<text fixtext=" ">
																								<styles font-family="Verdana" font-size="11pt"/>
																							</text>
																							<combobox>
																								<children>
																									<content subtype="regular"/>
																								</children>
																								<selectoption description="standard code" value="code"/>
																								<selectoption description="text" value="displayName"/>
																							</combobox>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																</children>
															</tgridheader-rows>
															<tgridbody-rows>
																<children>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<text fixtext="Parameter value prefix">
																						<styles font-family="Verdana" font-size="11pt"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<styles text-align="left"/>
																				<children>
																					<template subtype="element" match="syntaxOnResource">
																						<children>
																							<template subtype="attribute" match="valuePrefix">
																								<children>
																									<content subtype="regular"/>
																								</children>
																								<variables/>
																							</template>
																							<newline/>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<text fixtext="Parameter name*">
																						<styles font-family="Verdana" font-size="11pt" font-weight="bold"/>
																					</text>
																					<text fixtext=" ">
																						<styles font-family="Verdana" font-size="11pt"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<styles text-align="left"/>
																				<children>
																					<template subtype="element" match="syntaxOnResource">
																						<children>
																							<template subtype="attribute" match="nonHl7CompliantName">
																								<children>
																									<content subtype="regular"/>
																								</children>
																								<variables/>
																							</template>
																							<newline/>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<text fixtext="Parameter value suffix">
																						<styles font-family="Verdana" font-size="11pt"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<styles text-align="left"/>
																				<children>
																					<template subtype="element" match="syntaxOnResource">
																						<children>
																							<template subtype="attribute" match="valueSuffix">
																								<children>
																									<content subtype="regular"/>
																								</children>
																								<variables/>
																							</template>
																							<newline/>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																</children>
															</tgridbody-rows>
														</children>
													</tgrid>
												</children>
												<variables/>
											</template>
										</children>
									</paragraph>
								</children>
							</conditionbranch>
						</children>
					</condition>
				</children>
			</globaltemplate>
		</children>
	</designfragments>
	<xmltables/>
	<authentic-custom-toolbar-buttons/>
</structure>
