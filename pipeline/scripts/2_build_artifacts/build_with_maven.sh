#!/bin/bash
################################################################################
#                               build_with_maven.sh                            #
#                                                                              #
# This script goal is to build of the project                                  #
#                                                                              #
# Change History                                                               #
# 01/10/2020  Dan MAGIER           Script to build the project with maven      #
#                                                                              #
#                                                                              #
################################################################################
################################################################################
################################################################################
#                                                                              #
#  Copyright (C) 2007, 2020 Dan MAGIER                                         #
#  dan@heiwa-it.com                                                            #
#                                                                              #
#  This program is free software; you can redistribute it and/or modify        #
#  it under the terms of the GNU General Public License as published by        #
#  the Free Software Foundation; either version 2 of the License, or           #
#  (at your option) any later version.                                         #
#                                                                              #
#  This program is distributed in the hope that it will be useful,             #
#  but WITHOUT ANY WARRANTY; without even the implied warranty of              #
#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the               #
#  GNU General Public License for more details.                                #
#                                                                              #
#  You should have received a copy of the GNU General Public License           #
#  along with this program; if not, write to the Free Software                 #
#  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA   #
#                                                                              #
################################################################################
################################################################################
################################################################################

ARTIFACT_VERSION=$1
echo ARTIFACT_VERSION: "${ARTIFACT_VERSION}"
echo MAVEN_GOAL: "${MAVEN_GOAL}"
echo MAVEN_CLI_OPTS: "${MAVEN_CLI_OPTS}"

################################################################################
# build_with_maven                                                             #
################################################################################
function build()
{
  echo "Using mvnw"
  ./mvnw versions:set -DnewVersion="${ARTIFACT_VERSION}" ${MAVEN_CLI_OPTS}  || exit 1
  ./mvnw ${MAVEN_GOAL} ${MAVEN_CLI_OPTS} -fn || exit 1
  ./mvnw versions:revert ${MAVEN_CLI_OPTS}  || exit 1
}

################################################################################
################################################################################
# Main program                                                                 #
################################################################################
################################################################################

###################################################
# Launch the build of the project depending of the
# options provided.
# Outputs:
#   Different artifacts stored in the build folder
# Returns:
#   0 if everything went fine, else 1
####################################################
build