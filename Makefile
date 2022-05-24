include .project.env

ARTIFACT_VERSION := $(shell ./pipeline/scripts/1_setup/determine_version.sh "${COMMIT_BRANCH}" "${VERSION}")

all : 	ci clean
.PHONY: all

ci : 	setup build generate_living_documentation_for_domain
.PHONY: ci

setup :  check
.PHONY: setup

start_exposition_locally : setup
	./pipeline/scripts/start_exposition_locally.sh "${ARTIFACT_VERSION}"
.PHONY: start_exposition_locally

# setup
check :
	./pipeline/scripts/1_setup/check_pipeline_variables.sh
.PHONY: check

# Build
build :
	./pipeline/scripts/2_build_artifacts/build.sh "${ARTIFACT_VERSION}"
.PHONY: build
# Quality
generate_living_documentation_for_domain :
	./pipeline/scripts/3_quality/generate_living_documentation.sh domain "${ARTIFACT_VERSION}" "${CUKEDOCTOR_MAIN_JAR}"
.PHONY: generate_living_documentation_for_domain
launch_quality_scan :
	./pipeline/scripts/3_quality/launch_quality_scan.sh "${ARTIFACT_VERSION}" "${COMMIT_BRANCH}"
.PHONY: launch_quality_scan

# update dependencies versions
updating_versions :
	./pipeline/scripts/update_versions.sh
.PHONY: updating_versions

# clean
clean :
	./pipeline/scripts/clean.sh "${BUILD_TYPE}"
.PHONY: clean