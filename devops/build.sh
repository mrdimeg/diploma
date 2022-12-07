#!/bin/bash
set -e -x

# Build the docker image

docker build --platform=linux/amd64 --tag ghcr.io/mrdimeg/diploma:latest -f Dockerfile .
docker push ghcr.io/mrdimeg/diploma:latest
