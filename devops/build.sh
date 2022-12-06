#!/bin/bash
set -e -x

# Build the docker image

docker build -t ghcr.io/mrdimeg/diploma:latest -f devops/Dockerfile .
docker push ghcr.io/mrdimeg/diploma:latest
