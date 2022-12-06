#!/bin/bash
set -e -x

# Build the image
echo $GITHUB_TOKEN | docker login ghcr.io -u mrdimeg --password-stdin
docker build -t ghcr.io/mrdimeg/diploma:latest -f devops/Dockerfile .
docker push ghcr.io/mrdimeg/diploma:latest