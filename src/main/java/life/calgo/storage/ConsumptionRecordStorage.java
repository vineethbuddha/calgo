package life.calgo.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import life.calgo.commons.exceptions.DataConversionException;
import life.calgo.model.ReadOnlyConsumptionRecord;

/**
 * Represents a storage for {@link ReadOnlyConsumptionRecord}.
 */
public interface ConsumptionRecordStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getConsumptionRecordFilePath();

    /**
     * Returns ConsumptionRecord data as a {@link ReadOnlyConsumptionRecord}.
     * Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<ReadOnlyConsumptionRecord> readConsumptionRecord() throws DataConversionException;

    /**
     * @see #getConsumptionRecordFilePath()
     */
    Optional<ReadOnlyConsumptionRecord> readConsumptionRecord(Path filePath) throws DataConversionException;

    /**
     * Saves the given {@link ReadOnlyConsumptionRecord} to the storage.
     * @param consumptionRecord cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveConsumptionRecord(ReadOnlyConsumptionRecord consumptionRecord) throws IOException;

    /**
     * @see #saveConsumptionRecord(ReadOnlyConsumptionRecord, Path)
     */
    void saveConsumptionRecord(ReadOnlyConsumptionRecord consumptionRecord, Path filePath) throws IOException;

}
