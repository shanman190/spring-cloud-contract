package org.springframework.cloud.contract.verifier.plugin;

import org.gradle.api.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeprecatedSpringCloudContractVerifierGradlePlugin extends SpringCloudContractVerifierGradlePlugin {
	private static final Logger logger = LoggerFactory.getLogger(DeprecatedSpringCloudContractVerifierGradlePlugin.class);

	@Override
	public void apply(Project project) {
		logger.warn("The plugin id 'spring-cloud-contract' is deprecated. Please use 'org.springframework.cloud.contract' instead.");
		super.apply(project);
	}
}
