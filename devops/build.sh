#!/bin/bash
set -e -x

# Build the docker image
echo $CR_PAT | docker login ghcr.io -u mrdimeg --password-stdin
docker build -t ghcr.io/mrdimeg/diploma:latest -f devops/Dockerfile .
docker push ghcr.io/mrdimeg/diploma:latest
