docker exec -it portal-servicos-api-postgres-1 psql -U postgres -d portalservicos

\c portalservicos

DROP SCHEMA portalservicos CASCADE;