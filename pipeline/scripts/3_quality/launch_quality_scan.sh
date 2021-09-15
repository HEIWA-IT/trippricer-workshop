#!/bin/bash
################################################################################
#                               sonarqube_scan.sh                              #
#                                                                              #
# This script goal is to launch the quality scan of the project                #
#                                                                              #
# Change History                                                               #
# 01/10/2020  Dan MAGIER           Script to launch the quality scan of        #
#                                  the project                                 #
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
BRANCH_NAME=$2
##################################################
# Generates quality report
# Globals:
#   - SONARQUBE_URL   : Sonarqube url
#   - SONARQUBE_CREDENTIALS : Sonarqube credentials
# Outputs:
#   Generates report in the build folder of module
#   filled as argument and exports it to a remote
#   server.
# Returns:
#   0 if the scan is executed normally, else 1.
##################################################
function launch_quality_scan() {
  sonar-scanner -Dsonar.host.url=${SONARQUBE_URL} \
    -Dsonar.login=${SONARQUBE_CREDENTIALS} \
    -Dsonar.projectVersion=${ARTIFACT_VERSION}
    #-Dsonar.branch.name=${BRANCH_NAME}
}

################################################################################
################################################################################
# Main program                                                                 #
################################################################################
launch_quality_scan