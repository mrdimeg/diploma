#!/bin/bash
set -e -x

# Build the docker image

docker build --tag ghcr.io/mrdimeg/diploma:latest -f Dockerfile .
docker push ghcr.io/mrdimeg/diploma:latest
