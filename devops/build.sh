#!/bin/bash
set -e -x

# Build the docker image
docker login ghcr.io -u mrdimeg -p $CR_PAT
docker build -t ghcr.io/mrdimeg/diploma:latest -f devops/Dockerfile .
docker push ghcr.io/mrdimeg/diploma:latest
